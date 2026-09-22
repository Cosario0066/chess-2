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

        data.board.forEach((row, y) => {
            row.forEach((cell, x) => {
                const cellElement = document.createElement('div');
                const isLight = (x + y) % 2 === 0;

                cellElement.className = `cell ${isLight ? 'light' : 'dark'}`;

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
