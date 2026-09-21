async function loadBoard() {
    const boardElement = document.getElementById('board');

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
                    const pieceElement = document.createElement('span');
                    const isBlack = cell === cell.toLowerCase();

                    pieceElement.className = `piece ${isBlack ? 'black' : 'white'}`;
                    pieceElement.textContent = cell;
                    cellElement.appendChild(pieceElement);
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
