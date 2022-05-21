import java.awt.*;
import java.util.*;

public class Block{
  
  public String type;
  public int orient;
  public int x;
  public int y;
  
  public Block(int block_x, int block_y, String blockType){
    type = blockType;
    orient = 0;
    x = block_x;
    y = block_y;
  }
  
  public void changeOrient(int n){
    if (type.equals("T") || type.equals("L") || type.equals("R")){
      orient += n;
      if (orient > 3){
        orient = 0;
      }else if (orient < 0){
        orient = 3;
      }
    }else if (type.equals("I") || type.equals("S") || type.equals("Z")){
      orient += n;
      if (orient > 1){
        orient = 0;
      }else if (orient < 0){
        orient = 1;
      }
    }
  }
  
  public boolean withinBounds(int min_x, int min_y, int max_x, int max_y){
    if (min_x > 1 && min_y > 1 && max_x < 12 && max_y < 16){
      return true;
    }
    return false;
  }
  
  public boolean checkCollision(int block_x, int block_y, String [][] gameBoard){
    if (type.equals("T")){
      if (orient == 0){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y][block_x + 1] == "_" && gameBoard[block_y][block_x - 1] == "_" && gameBoard[block_y + 1][block_x] == "_" && withinBounds(block_x - 1, block_y, block_x + 1, block_y + 1)){
          return true;
        }
      }else if (orient == 1){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y + 1][block_x] == "_" && gameBoard[block_y - 1][block_x] == "_" && gameBoard[block_y][block_x - 1] == "_" && withinBounds(block_x - 1, block_y - 1, block_x, block_y + 1)){
          return true;
        }
      }else if (orient == 2){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y][block_x + 1] == "_" && gameBoard[block_y][block_x - 1] == "_" && gameBoard[block_y - 1][block_x] == "_" && withinBounds(block_x - 1, block_y - 1, block_x + 1, block_y)){
          return true;
        }
      }else if (orient == 3){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y + 1][block_x] == "_" && gameBoard[block_y - 1][block_x] == "_" && gameBoard[block_y][block_x + 1] == "_" && withinBounds(block_x, block_y - 1, block_x + 1, block_y + 1)){
          return true;
        }
      }
    }else if (type.equals("I")){
      if (orient == 0){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y][block_x - 1] == "_" && gameBoard[block_y][block_x + 1] == "_" && gameBoard[block_y][block_x + 2] == "_" && withinBounds(block_x - 1, block_y, block_x + 2, block_y)){
          return true;
        }
      }else if (orient == 1){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y - 1][block_x] == "_" && gameBoard[block_y + 1][block_x] == "_" && gameBoard[block_y + 2][block_x] == "_" && withinBounds(block_x, block_y - 1, block_x, block_y + 2)){
          return true;
        }
      }
    }else if (type.equals("L")){
      if (orient == 0){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y][block_x + 1] == "_" && gameBoard[block_y][block_x - 1] == "_" && gameBoard[block_y + 1][block_x - 1] == "_" && withinBounds(block_x - 1, block_y, block_x + 1, block_y + 1)){
          return true;
        }
      }else if (orient == 1){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y + 1][block_x] == "_" && gameBoard[block_y - 1][block_x ] == "_" && gameBoard[block_y - 1][block_x - 1] == "_" && withinBounds(block_x - 1, block_y - 1, block_x, block_y + 1)){
          return true;
        }
      }else if (orient == 2){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y][block_x - 1] == "_" && gameBoard[block_y][block_x + 1] == "_" && gameBoard[block_y - 1][block_x + 1] == "_" && withinBounds(block_x - 1, block_y - 1, block_x + 1, block_y)){
          return true;
        }
      }else if (orient == 3){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y - 1][block_x] == "_" && gameBoard[block_y + 1][block_x ] == "_" && gameBoard[block_y + 1][block_x + 1] == "_" && withinBounds(block_x, block_y - 1, block_x + 1, block_y + 1)){
          return true;
        }
      }
    }else if (type.equals("R")){
      if (orient == 0){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y][block_x + 1] == "_" && gameBoard[block_y][block_x - 1] == "_" && gameBoard[block_y + 1][block_x + 1] == "_" && withinBounds(block_x - 1, block_y, block_x + 1, block_y + 1)){
          return true;
        }
      }else if (orient == 1){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y - 1][block_x] == "_" && gameBoard[block_y + 1][block_x ] == "_" && gameBoard[block_y + 1][block_x - 1] == "_" && withinBounds(block_x - 1, block_y - 1, block_x, block_y + 1)){
          return true;
        }
      }else if (orient == 2){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y][block_x - 1] == "_" && gameBoard[block_y][block_x + 1] == "_" && gameBoard[block_y - 1][block_x - 1] == "_" && withinBounds(block_x - 1, block_y - 1, block_x + 1, block_y)){
          return true;
        }
      }else if (orient == 3){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y + 1][block_x] == "_" && gameBoard[block_y - 1][block_x ] == "_" && gameBoard[block_y - 1][block_x + 1] == "_" && withinBounds(block_x, block_y - 1, block_x + 1, block_y + 1)){
          return true;
        }
      }
    }else if (type.equals("S")){
      if (orient == 0){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y][block_x + 1] == "_" && gameBoard[block_y + 1][block_x] == "_" && gameBoard[block_y + 1][block_x - 1] == "_" && withinBounds(block_x - 1, block_y, block_x + 1, block_y + 1)){
          return true;
        }
      }else if (orient == 1){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y - 1][block_x] == "_" && gameBoard[block_y][block_x + 1] == "_" && gameBoard[block_y + 1][block_x + 1] == "_" && withinBounds(block_x, block_y - 1, block_x + 1, block_y + 1)){
          return true;
        }
      }
    }else if (type.equals("Z")){
      if (orient == 0){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y][block_x - 1] == "_" && gameBoard[block_y + 1][block_x] == "_" && gameBoard[block_y + 1][block_x + 1] == "_" && withinBounds(block_x - 1, block_y, block_x + 1, block_y + 1)){
          return true;
        }
      }else if (orient == 1){
        if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y + 1][block_x] == "_" && gameBoard[block_y][block_x + 1] == "_" && gameBoard[block_y - 1][block_x + 1] == "_" && withinBounds(block_x, block_y - 1, block_x + 1, block_y + 1)){
          return true;
        }
      }
    }else if (type.equals("E")){
      if (gameBoard[block_y][block_x] == "_" && gameBoard[block_y + 1][block_x] == "_" && gameBoard[block_y + 1][block_x + 1] == "_" && gameBoard[block_y][block_x + 1] == "_" && withinBounds(block_x, block_y, block_x + 1, block_y + 1)){
        return true;
      }
    }
    return false;
  }
  
  public String [][] clearBlock(String [][] gameBoard){
    if (type.equals("T")){
      if (orient == 0){
        gameBoard[y][x] = "_";
        gameBoard[y][x + 1] = "_";
        gameBoard[y][x - 1] = "_";
        gameBoard[y + 1][x] = "_";
      }else if (orient == 1){
        gameBoard[y][x] = "_";
        gameBoard[y + 1][x] = "_";
        gameBoard[y - 1][x] = "_";
        gameBoard[y][x - 1] = "_";
      }else if (orient == 2){
        gameBoard[y][x] = "_";
        gameBoard[y][x + 1] = "_";
        gameBoard[y][x - 1] = "_";
        gameBoard[y - 1][x] = "_";
      }else if (orient == 3){
        gameBoard[y][x] = "_";
        gameBoard[y + 1][x] = "_";
        gameBoard[y - 1][x] = "_";
        gameBoard[y][x + 1] = "_";
      }
    }else if (type.equals("I")){
      if (orient == 0){
        gameBoard[y][x] = "_";
        gameBoard[y][x - 1] = "_";
        gameBoard[y][x + 1] = "_";
        gameBoard[y][x + 2] = "_";
      }else if (orient == 1){
        gameBoard[y][x] = "_";
        gameBoard[y - 1][x] = "_";
        gameBoard[y + 1][x] = "_";
        gameBoard[y + 2][x] = "_";
      }
    }else if (type.equals("L")){
      if (orient == 0){
        gameBoard[y][x] = "_";
        gameBoard[y][x + 1] = "_";
        gameBoard[y][x - 1] = "_";
        gameBoard[y + 1][x - 1] = "_";
      }else if (orient == 1){
        gameBoard[y][x] = "_";
        gameBoard[y + 1][x] = "_";
        gameBoard[y - 1][x] = "_";
        gameBoard[y - 1][x - 1] = "_";
      }else if (orient == 2){
        gameBoard[y][x] = "_";
        gameBoard[y][x - 1] = "_";
        gameBoard[y][x + 1] = "_";
        gameBoard[y - 1][x + 1] = "_";
      }else if (orient == 3){
        gameBoard[y][x] = "_";
        gameBoard[y - 1][x] = "_";
        gameBoard[y + 1][x] = "_";
        gameBoard[y + 1][x + 1] = "_";
      }
    }else if (type.equals("R")){
      if (orient == 0){
        gameBoard[y][x] = "_";
        gameBoard[y][x + 1] = "_";
        gameBoard[y][x - 1] = "_";
        gameBoard[y + 1][x + 1] = "_";
      }else if (orient == 1){
        gameBoard[y][x] = "_";
        gameBoard[y - 1][x] = "_";
        gameBoard[y + 1][x] = "_";
        gameBoard[y + 1][x - 1] = "_";
      }else if (orient == 2){
        gameBoard[y][x] = "_";
        gameBoard[y][x - 1] = "_";
        gameBoard[y][x + 1] = "_";
        gameBoard[y - 1][x - 1] = "_";
      }else if (orient == 3){
        gameBoard[y][x] = "_";
        gameBoard[y + 1][x] = "_";
        gameBoard[y - 1][x] = "_";
        gameBoard[y - 1][x + 1] = "_";
      }
    }else if (type.equals("S")){
      if (orient == 0){
        gameBoard[y][x] = "_";
        gameBoard[y][x + 1] = "_";
        gameBoard[y + 1][x] = "_";
        gameBoard[y + 1][x - 1] = "_";
      }else if (orient == 1){
        gameBoard[y][x] = "_";
        gameBoard[y - 1][x] = "_";
        gameBoard[y][x + 1] = "_";
        gameBoard[y + 1][x + 1] = "_";
      }
    }else if (type.equals("Z")){
      if (orient == 0){
        gameBoard[y][x] = "_";
        gameBoard[y][x - 1] = "_";
        gameBoard[y + 1][x] = "_";
        gameBoard[y + 1][x + 1] = "_";
      }else if (orient == 1){
        gameBoard[y][x] = "_";
        gameBoard[y + 1][x] = "_";
        gameBoard[y][x + 1] = "_";
        gameBoard[y - 1][x  + 1] = "_";
      }
    }else if (type.equals("E")){
      gameBoard[y][x] = "_";
      gameBoard[y + 1][x] = "_";
      gameBoard[y + 1][x + 1] = "_";
      gameBoard[y][x + 1] = "_";
    }
    return gameBoard;
  }
  
  public String [][] drawBlock(int block_x, int block_y, String [][] gameBoard){
    if (type.equals("T")){
      if (orient == 0){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "T";
        gameBoard[y][x + 1] = "T";
        gameBoard[y][x - 1] = "T";
        gameBoard[y + 1][x] = "T";
      }else if (orient == 1){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "T";
        gameBoard[y + 1][x] = "T";
        gameBoard[y - 1][x] = "T";
        gameBoard[y][x - 1] = "T";
        
      }else if (orient == 2){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "T";
        gameBoard[y][x + 1] = "T";
        gameBoard[y][x - 1] = "T";
        gameBoard[y - 1][x] = "T";
      }else if (orient == 3){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "T";
        gameBoard[y + 1][x] = "T";
        gameBoard[y - 1][x] = "T";
        gameBoard[y][x + 1] = "T";
      }
    }else if (type.equals("I")){
      if (orient == 0){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "I";
        gameBoard[y][x - 1] = "I";
        gameBoard[y][x + 1] = "I";
        gameBoard[y][x + 2] = "I";
      }else if (orient == 1){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "I";
        gameBoard[y - 1][x] = "I";
        gameBoard[y + 1][x] = "I";
        gameBoard[y + 2][x] = "I";
      }
    }else if (type.equals("L")){
      if (orient == 0){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "L";
        gameBoard[y][x + 1] = "L";
        gameBoard[y][x - 1] = "L";
        gameBoard[y + 1][x - 1] = "L";
      }else if (orient == 1){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "L";
        gameBoard[y + 1][x] = "L";
        gameBoard[y - 1][x] = "L";
        gameBoard[y - 1][x - 1] = "L";
      }else if (orient == 2){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "L";
        gameBoard[y][x - 1] = "L";
        gameBoard[y][x + 1] = "L";
        gameBoard[y - 1][x + 1] = "L";
        
      }else if (orient == 3){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "L";
        gameBoard[y - 1][x] = "L";
        gameBoard[y + 1][x] = "L";
        gameBoard[y + 1][x + 1] = "L";
      }
    }else if (type.equals("R")){
      if (orient == 0){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "R";
        gameBoard[y][x + 1] = "R";
        gameBoard[y][x - 1] = "R";
        gameBoard[y + 1][x + 1] = "R";
      }else if (orient == 1){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "R";
        gameBoard[y - 1][x] = "R";
        gameBoard[y + 1][x] = "R";
        gameBoard[y + 1][x - 1] = "R";
      }else if (orient == 2){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "R";
        gameBoard[y][x - 1] = "R";
        gameBoard[y][x + 1] = "R";
        gameBoard[y - 1][x - 1] = "R";
      }else if (orient == 3){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "R";
        gameBoard[y + 1][x] = "R";
        gameBoard[y - 1][x] = "R";
        gameBoard[y - 1][x + 1] = "R";
      }
    }else if (type.equals("S")){
      if (orient == 0){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "S";
        gameBoard[y][x + 1] = "S";
        gameBoard[y + 1][x] = "S";
        gameBoard[y + 1][x - 1] = "S";
      }else if (orient == 1){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "S";
        gameBoard[y - 1][x] = "S";
        gameBoard[y][x + 1] = "S";
        gameBoard[y + 1][x + 1] = "S";
      }
    }else if (type.equals("Z")){
      if (orient == 0){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "Z";
        gameBoard[y][x - 1] = "Z";
        gameBoard[y + 1][x] = "Z";
        gameBoard[y + 1][x + 1] = "Z";
      }else if (orient == 1){
        x = block_x;
        y = block_y;
        gameBoard[y][x] = "Z";
        gameBoard[y + 1][x] = "Z";
        gameBoard[y][x + 1] = "Z";
        gameBoard[y - 1][x  + 1] = "Z";
      }
    }else if (type.equals("E")){
      x = block_x;
      y = block_y;
      gameBoard[y][x] = "E";
      gameBoard[y + 1][x] = "E";
      gameBoard[y + 1][x + 1] = "E";
      gameBoard[y][x + 1] = "E";
    }
    return gameBoard;
  }
}
