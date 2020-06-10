document.addEventListener('DOMContentLoaded', () =>{
    let squares = Array.from(document.querySelectorAll('.grid div'));
    const grid = document.querySelector('.grid');
    const scoreDisplay = document.querySelector('#score');
    const startBtn = document.querySelector("#start-button")
    const width =10;
    let timerID; //auto sets to null when not assigned to anything
//Tetrminoes
const lTetromino =[
    [1, width+1, width*2+1,2],
    [width, width +1, width+2, width*2+2],
    [1, width+1, width*2+1, width*2],
    [width, width*2, width*2+1, width*2+2]
];

const zTetromino=[
    [0,width, width+1, width*2+1],
    [width+1, width+2,width*2, width*2+1],
    [0, width,width+1, width*2+1],
    [width+1, width+2, width*2, width*2+1]
];

const tTetrimino =[
    [1,width,width+1,width+2],
    [1,width+1,width+2,width*2+1],
    [width,width+1,width+2, width*2+1],
    [1,width,width+1,width+2]

];
const oTetromino=[
    [0,1,width,width+1],
    [0,1,width,width+1],
    [0,1,width,width+1],
    [0,1,width,width+1]
];

const iTetromino=[
    [1, width+1, width*2+1, width*3+1],
    [width, width+1, width+2,width+3],
    [1, width+1, width*2+1, width*3+1]
    [width, width+1, width+2,width+3]
];

const theTetrimnoes=[lTetromino,zTetromino,tTetrimino, oTetromino, iTetromino];

let currentPosition =4;
let currnetRotation =0;

//randomly select a tetromino
let random = Math.floor(Math.random()*theTetrimnoes.length);
let current = theTetrimnoes[0][0];

//draw the  tetromino
function draw()
{
    current.forEach(index =>{
        squares[currentPosition +index].classList.add('tetromino');
    });
}

function undraw(){
    current.forEach(index=>{
        squares[currentPosition+index].classList.remove('tetromino');
    });
}
//assign key event listeners
function control(e)
{
    if(e.keyCode ===37)
    {
        moveLeft();
    }
    else if(e.keyCode ===38)
    {
        rotate();
    }
    else if(e.keyCode===39)
    {
        moveRight();
    }
    else if(e.keyCode ===40)
    {
        moveDown();
    }

}
document.addEventListener('keyup', control);

function moveDown()
{
    undraw();
    currentPosition+=width;
    draw();
    freeze();
}


function freeze()
{
 if(current.some(index=>squares[currentPosition + index + width].classList.contains('taken')))
 {
    current.forEach(index=>squares[currentPosition + index].classList.add('taken'));
    //start new tetromino falling
    random = nextRandom;
    nextRandom =Math.floor(Math.random()* theTetrimnoes.length);
    current =theTetrimnoes[random][currnetRotation];
    currentPosition =4;
    draw();
    displayShape();
    addScore();
 }
}

// move the tetrominoes left 
function moveLeft()
{
    undraw();
    const isAtLeftEdge = current.some(index =>(currentPosition + index) % width === 0 ) 
    if(!isAtLeftEdge) currentPosition -=1;
    if(current.some(index=>squares[currentPosition +index].classList.contains('taken')))
    {
        currentPosition +=1;
    }
    draw();
}
 
function moveRight()
{
    undraw();
    const isAtRightEdge = current.some(index => (currentPosition+index) % width ===width-1);
    if(!isAtRightEdge) 
        currentPosition+=1;
    if(current.some(index=>squares[currentPosition+index].classList.contains('taken')))
    {
        currentPosition-=1;
    }
    draw();
}

//rotate tetromino
function rotate()
{
    undraw();
    currnetRotation++;
    // if the current rotations is 4, make it go back to 0
    if(currnetRotation === current.length)
    {
        currnetRotation =0;
    }
    current = theTetrimnoes[random][currnetRotation];
    draw();
}

//show the next tetromino in mini-grid
const displaySquares = document.querySelectorAll('.mini-grid div');
const displayWidth =4;
let displayIndex =0;
let nextRandom =0;
//the tetrominos without rotations
const upNextTetrominoes =[
    [1, displayWidth+1, displayWidth*2+1,2], //lTetromino
    [0,displayWidth, displayWidth+1, displayWidth*2+1], //zTetromino
    [1,displayWidth, displayWidth+1, displayWidth+2], //tTetromino
    [0,1,displayWidth,displayWidth+1], //oTetromino
    [1,displayWidth+1, displayWidth*2+1, displayWidth*3+1] //iTetromino
]

//display shape in mini-grid display
function displayShape()
{
    //remove any trace of tetrominos from the entire grid
    displaySquares.forEach(square => {
        square.classList.remove('tetromino') 
    });
    upNextTetrominoes[nextRandom].forEach(index =>{
        displaySquares[displayIndex + index].classList.add('tetromino')
    });
 }

//functionality of start and pause button
startBtn.addEventListener('click', () =>{
if(timerID){
    clearInterval(timerID)
    timerID=null;
}
else{
    draw();
    timerID=setInterval(moveDown,1000);
    nextRandom = Math.floor(Math.random()*theTetrimnoes.length);
    displayShape();
}
})

//score Keeper
function addScore()
{
    for (let i =0; i<199; i+=width)
    {
        const row = [i, i+1, i+2, i+3, i+4, i+5, i+6, i+7 , i+8, i+8, i+9]; 
        if(row.every(index => squares[index].classList.classList.contains('taken')))
        {
            score+=10;
            scoreDisplay.innerHTML=score;
            row.forEach(index =>{
                squares[index].classList.remove('taken')
            });
            const squaresRemoved = squares.splice(i, width);
            squares=squaresRemoved.concat(squares);
            squares.forEach(cell => grid.appendChild(cell))
        }
    }
}
 
})