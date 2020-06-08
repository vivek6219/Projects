document.addEventListener('DOMContentLoaded', () =>{
    let squares = Array.from(document.querySelectorAll('.grid div'));
    const grid = document.querySelector('.grid');
    const scoreDisplay = document.querySelector('#score');
    const startBtn = document.querySelector("#start-button")
    const width =10;

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

})