async function getPossibleMoves(x, y) {
    const response = await fetch(`/api/possible-moves?x=${x}&y=${y}`);
    if (!response.ok) {
        throw new Error(`Impossible de récupérer les mouvements (${response.status})`);
    }
    return (await response.json()).possibleMoves
        .map((move) => move.split(',').map(Number));
}

function clearHighlights() {
    document.querySelectorAll('.cell.selected, .cell.possible-move')
        .forEach((cell) => {
            cell.classList.remove('selected', 'possible-move');
            cell.onclick = null;
        });
}

async function selectPiece(x, y, cellElement) {
    clearHighlights();
    cellElement.classList.add('selected');

    const possibleMoves = await getPossibleMoves(x, y);
    possibleMoves.forEach(([moveX, moveY]) => {
        const targetCell = document.querySelector(`[data-x="${moveX}"][data-y="${moveY}"]`);
        if (targetCell) {
            targetCell.classList.add('possible-move');
            targetCell.onclick = () => movePiece(x, y, moveX, moveY).catch(console.error);
        }
    });
}

async function movePiece(fromX, fromY, toX, toY) {
    const response = await fetch('/api/move', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ fromX, fromY, toX, toY })
    });

    if (!response.ok) {
        throw new Error(`Impossible de déplacer la pièce (${response.status})`);
    }

    await loadBoard();
}

async function loadBoard() {
    const boardElement = document.getElementById('board');
    const pieceIcons = {
        k: 'fa-chess-king',
        q: 'fa-chess-queen',
        r: 'fa-chess-rook',
        b: 'fa-chess-bishop',
        n: 'fa-chess-knight',
        p: 'fa-chess-pawn'
    };
    const pieceNames = {
        k: 'roi',
        q: 'reine',
        r: 'tour',
        b: 'fou',
        n: 'cavalier',
        p: 'pion'
    };

    try {
        const response = await fetch('/api/board');
        if (!response.ok) {
            throw new Error(`Impossible de charger le plateau (${response.status})`);
        }

        const data = await response.json();
        const size = data.size;

        boardElement.innerHTML = '';
        boardElement.style.gridTemplateColumns = `repeat(${size}, 52px)`;
        boardElement.style.gridTemplateRows = `repeat(${size}, 52px)`;

        data.board.forEach((row, displayRow) => {
            const y = size - 1 - displayRow;
            row.forEach((cell, displayColumn) => {
                const x = size - 1 - displayColumn;
                const cellElement = document.createElement('div');
                const isLight = (x + y) % 2 === 0;

                cellElement.className = `cell ${isLight ? 'light' : 'dark'}`;
                cellElement.dataset.x = x;
                cellElement.dataset.y = y;
                cellElement.addEventListener('click', () => {
                    if (cellElement.classList.contains('possible-move')) {
                        return;
                    }
                    if (cell && cell !== '.') {
                        selectPiece(x, y, cellElement).catch(console.error);
                    } else {
                        clearHighlights();
                    }
                });

                if (cell && cell !== '.') {
                    const pieceElement = document.createElement('i');
                    const isBlack = cell === cell.toLowerCase();
                    const icon = pieceIcons[cell.toLowerCase()];

                    if (icon) {
                        pieceElement.className = `piece ${isBlack ? 'black' : 'white'} fa-solid ${icon}`;
                        pieceElement.setAttribute('aria-label', `${isBlack ? 'Noir' : 'Blanc'} ${pieceNames[cell.toLowerCase()]}`);
                        cellElement.appendChild(pieceElement);
                    }
                }

                boardElement.appendChild(cellElement);
            });
        });
    } catch (error) {
        boardElement.textContent = 'Erreur de chargement du plateau';
        console.error(error);
    }
}

loadBoard();
