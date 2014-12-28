/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parser;
import java.io.*;
import AST.*;

/**
 *
 * @author FallenShard
 */
public class MainClass
{
    public static void main(String[] args)
    {
        try
        {
          FileReader file = new FileReader(args[0]);
          MyLexer scanner = new MyLexer( file );
          MyParser parser = new MyParser(scanner);
          ASTNode ast = (ASTNode) parser.parse().value;
          String outFileName = args[0].substring(0, args[0].indexOf( ".") + 1);
          outFileName += "ic";
          BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));
          ast.translate(writer);
          writer.close();
        }
        catch(Exception e)
        {
           System.out.println(e);
           e.printStackTrace();
        }
    }
}




