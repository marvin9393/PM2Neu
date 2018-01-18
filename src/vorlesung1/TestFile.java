/**
*
*
*
*/
package vorlesung1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt xx, Aufgabe xx
* Verwendete Quellen: */
public class TestFile {
  private FileInputStream inFile = null;
  private FileOutputStream outFile = null;
  
  
  public TestFile() {
    
  }
 
private void testFileOhneTryWithResources() {
  try {
    File file =new File("files"+File.separator+"unsortiert.txt");
    file.createNewFile();
    inFile = new FileInputStream("files"+File.separator+"unsortiert.txt");
    outFile = new FileOutputStream("files"+File.separator+"unsortiert_copy.txt");
    byte[] buffer = new byte[65536];
    int len;
    while((len=inFile.read(buffer))>0) {
      outFile.write(buffer,0,len);
    }
    try {
      inFile.close();
      outFile.close();
    }catch(IOException e1){
      
    }
  }catch(FileNotFoundException e){
    try {
      inFile.close();
      outFile.close();
    }catch(IOException e1) {
      
    }
  }catch (IOException e) {
    try {
      inFile.close();
      outFile.close();
    }catch(IOException e1) {
      
    }
  }
}

private void testFileMitFileOhneTryWithResources() {
  File file =new File("file.txt");
  try {
    file.createNewFile();
  } catch (IOException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
  }
  try (FileInputStream inFile =new FileInputStream("file.txt");){
    byte [] buffer = new byte[65536];
    int len;
    while ((len=inFile.read(buffer))>0) {
      System.out.println(buffer);
    }
  }catch(FileNotFoundException e) {
    e.printStackTrace();
  }catch(IOException e) {
    e.printStackTrace();
  }
}
  public static void main(String[] args) {
    TestFile file = new TestFile();
    file.testFileOhneTryWithResources();
    file.testFileMitFileOhneTryWithResources();
    
  }
}
