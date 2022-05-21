import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main extends JPanel implements KeyListener{
  boolean gameStart = false;

  static String [] blockList = {"T", "L", "R", "I", "S", "Z", "E"};
  Block newBlock = new Block(6, 3, blockList[(int)Math.round(Math.random()*6)]);
  
  static String [][] gameBoard = new String[18][14];
  
  static int block_x = 6;
  static int block_y = 3;

  static int level = 1;
  static int difficulty = 1000;
  
  public static void main(String[] args){
    JFrame frame = new JFrame();
    frame.setTitle("Tetris");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(0, 0);
    frame.setVisible(true);
    Main k = new Main();
    frame.addKeyListener(k);
  }
     
  public void initiate(){
    for (int y = 0; y < 18; y++){
      for (int x = 0; x < 14; x++){
        gameBoard[y][x] = "_";
      }
    }
    gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
    displayBoard();
    level -= level % 10;
  }
  
  public void purge(){
    ArrayList<Integer> purgeLine = new ArrayList<Integer>();
    String line = "";
    for (int y = 2; y < 16; y++){
      for (int x = 2; x < 12; x++){
        line += gameBoard[y][x];
      }
      if (line.indexOf("_") >= 0){
          line = "";
          continue;
      }
      line = "";
      purgeLine.add(y);
    }
    for (Integer c: purgeLine){
      for (int i = c; i > 1; i--){
        gameBoard[i] = gameBoard[i - 1].clone();
      }
      level++;
    }
    if (difficulty > 100 && level % 10 == 0){
      difficulty -= 100;
    }
  }
  
  public void displayBoard(){
    System.out.println("_____________________");
    for (int y = 2; y < 16; y++){
      System.out.print("|");
      for (int x = 2; x < 12; x++){
        System.out.print(gameBoard[y][x] + "|");
      }
      System.out.println();
    }
  }
     
  public void keyPressed(KeyEvent e){
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_RIGHT){//Right arrow key code
      block_x++;
      gameBoard = newBlock.clearBlock(gameBoard);
      if (newBlock.checkCollision(block_x, block_y, gameBoard)){
        gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
        displayBoard();
      }else{
        block_x--;
        gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
        displayBoard();
      }
    } else if (keyCode == KeyEvent.VK_LEFT){//Left arrow key code
      block_x--;
      gameBoard = newBlock.clearBlock(gameBoard);
      if (newBlock.checkCollision(block_x, block_y, gameBoard)){
        gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
        displayBoard();
      }else{
        block_x++;
        gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
        displayBoard();
      }
    } else if (keyCode == KeyEvent.VK_UP){//Up arrow key
      gameBoard = newBlock.clearBlock(gameBoard);
      newBlock.changeOrient(1);
      if (newBlock.checkCollision(block_x, block_y, gameBoard)){
        gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
        displayBoard();
      }else{
        newBlock.changeOrient(-1);
        gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
        displayBoard();
      }
    } else if (keyCode == KeyEvent.VK_DOWN){//Down arrow key
      block_y++;
      gameBoard = newBlock.clearBlock(gameBoard);
      if (newBlock.checkCollision(block_x, block_y, gameBoard)){
        gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
        displayBoard();
      }else{
        block_y--;
        gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
        purge();
        block_x = 6;
        block_y = 3;
        newBlock = new Block(block_x, block_y, blockList[(int)Math.round(Math.random()*6)]);
        if (!newBlock.checkCollision(block_x, block_y, gameBoard)){
          initiate();
        }else{
          gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
          displayBoard();
          level = 1;
        }
      }
    } else if (keyCode == KeyEvent.VK_SPACE){//down
      if (gameStart == false){
        gameStart = true;
        initiate();
        t.start();
      }else{
        gameBoard = newBlock.clearBlock(gameBoard);
        while (newBlock.checkCollision(block_x, block_y + 1, gameBoard)){
          block_y++;
        }
        gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
        purge();
        block_x = 6;
        block_y = 3;
        newBlock = new Block(block_x, block_y, blockList[(int)Math.round(Math.random()*6)]);
        if (!newBlock.checkCollision(block_x, block_y, gameBoard)){
          initiate();
        }else{
          gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
          displayBoard();
          level = 1;
        }
      }
    }
  }
     
  public void keyReleased(KeyEvent e){
  }
  
  public void keyTyped(KeyEvent e){    
  }
  
  public static void delay(int delay){
    long endDelay = 0;
    long startDelay = System.currentTimeMillis();
    while (endDelay - startDelay < delay){
      endDelay = System.currentTimeMillis();
    }
  }

  public void moveDown(){
    block_y++;
    gameBoard = newBlock.clearBlock(gameBoard);
    if (newBlock.checkCollision(block_x, block_y, gameBoard)){
      gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
      displayBoard();
    }else{
      block_y--;
      gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
      purge();
      block_x = 6;
      block_y = 3;
      newBlock = new Block(block_x, block_y, blockList[(int)Math.round(Math.random()*6)]);
      if (!newBlock.checkCollision(block_x, block_y, gameBoard)){
        initiate();
      }else{
        gameBoard = newBlock.drawBlock(block_x, block_y, gameBoard);
        displayBoard();
        level = 1;
      }
    }
  }
  
  Thread t = new Thread(new Runnable(){ //https://stackoverflow.com/questions/14366777/how-do-i-make-method-pause-without-pausing-the-whole-program/14366818
    public void run(){
      while (true){
        delay(difficulty);
        moveDown();
      }
    }
  });
}
