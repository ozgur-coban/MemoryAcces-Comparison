import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;




public class main {

    static double AvarageMemoryAccessForB;
    static double AvarageMemoryAccessForC;
    static ArrayList<Integer> postParseForSource = new ArrayList<Integer>();
    static ArrayList<Integer> postParseForSearch = new ArrayList<Integer>();
    
    
    
    
    
    

    public static LinkedList MethodForA(LinkedList List) throws Exception{
        int midArray[]=new int[postParseForSource.size()];
        for (int i=0 ; i<postParseForSource.size();i++){
            midArray[i]=(int) postParseForSource.get(i);
            
            if(List.Search(midArray[i])==false){
                    List.insertToEnd(midArray[i]);
                    
                }

        }
        //List.display();
        return List;


    }

    public static double MethodForB(LinkedList List) throws Exception{
        int midArray[]=new int [postParseForSearch.size()];
        double sizeForCalculation=midArray.length;
        for (int i=0; i<midArray.length;i++){
            midArray[i]=(int) postParseForSearch.get(i);
            List.SearchForTotalMemoryAccess(midArray[i]);

        }
        AvarageMemoryAccessForB=(List.MemoryAccess/sizeForCalculation);
        System.out.println("TotalMemoryAccessForB="+List.MemoryAccess);
        System.out.println("AvarageMemoryAccessForB="+AvarageMemoryAccessForB);
        return AvarageMemoryAccessForB;
        
    }


    public static double MethodForC(LinkedList List) throws Exception{
        int midArray[]=new int [postParseForSearch.size()];
        double sizeForCalculation=midArray.length;
        for (int i=0; i<midArray.length;i++){
            midArray[i]=(int) postParseForSearch.get(i);
            List.SearchAndPutToFront(midArray[i]);

        }
        
        AvarageMemoryAccessForC=(List.MemoryAccess2/sizeForCalculation);
        System.out.println("TotalMemoryAccessForC="+List.MemoryAccess2);
        System.out.println("AvarageMemoryAccessForC="+AvarageMemoryAccessForC);
        return AvarageMemoryAccessForC;
    }

    // public static void MethodForD(LinkedList List) throws Exception{
    //     if(AvarageMemoryAccessForB<AvarageMemoryAccessForC){
    //         System.out.println("Method B is more efficent");

    //     }
    //     else{
    //         System.out.println("Method C is more efficent");
    //     }
        
    // }


    public static void main(String[] args) throws Exception {
        try (
        PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Source.txt"), true));
        PrintWriter pw2 = new PrintWriter(new FileOutputStream(new File("Search.txt"), true));
    ) {
        
    for (int i = 0; i < 10000; i++) {
        pw.print((int)(Math.random() * 300) + ",");
        pw2.print((int)(Math.random() * 300) + ",");
        }
    } catch (FileNotFoundException fnfe) {
        System.out.println("Cannot create the file.");
        fnfe.printStackTrace();
    }
        
        File file=new File("Source.txt");
        Scanner sc=new Scanner(file);
        int index=0;
        while(sc.hasNext()){
            


            String a = sc.next();
            String[] test = a.split(",");
            
            
            
            while(test.length>index){
                int c = Integer.parseInt(test[index]);
                postParseForSource.add(c);
                
                
                
                
                



                

                index++;

                }

    }

        File fileSearch=new File("Search.txt");
        Scanner scSearch=new Scanner(fileSearch);
        int indexSearch=0;
        while(scSearch.hasNext()){
            


            String a = scSearch.next();
            String[] test = a.split(",");
            
            
            
            while(test.length>indexSearch){
                int c = Integer.parseInt(test[indexSearch]);
                postParseForSearch.add(c);
                
                
                
                
                



                

                indexSearch++;

                }

    }

    
    
    


        
    
    
    
    
    
    
    
    
    
    
        LinkedList List1 = new LinkedList<>();

        MethodForA(List1);
        List1.display();






        long startB = System.nanoTime();



        MethodForB(List1);
        



        long endB = System.nanoTime();
        long executionB = endB - startB;
        double divider= 1000000000;
        double executionBAsSecond=executionB/divider;
        System.out.println("Time it takes to execute Method B= " + executionBAsSecond);






        

        long startC = System.nanoTime();



        MethodForC(List1);



        long endC = System.nanoTime();
        long executionC = endC - startC;
        double executionCAsSecond=executionC/divider;
        System.out.println("Time it takes to execute Method C= " + executionCAsSecond);

        if(executionCAsSecond>executionBAsSecond){
            System.out.println("From comparing execution times , Method B is more efficent");
        }
        if(executionCAsSecond<executionBAsSecond){
            System.out.println("From comparing execution times , Method C is more efficent");
        }

        System.out.println("\n\nFrom comparing memory access' as the dublicate values increase , method c becomes more efficent . So if we reduce the gap between random integer values by decreasing the Multiplication value for Math.random or If we increase the total number of random integers by increasing 'i' while keeping the Multiplication value . Method C becomes more efficent.  ");
        
        
        
        
        
        
        
        
        
        
        // uncomment to reset both files to keep them at 10000 integers
        
        
        PrintWriter writer = new PrintWriter("Source.txt");
        writer.print("");
        writer.close();
        PrintWriter writer2 = new PrintWriter("Search.txt");
        writer2.print("");
        writer2.close();

        
        
        
        
        
        
        
        






                
            
            }
        

        
    
}

