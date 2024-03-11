public class LinkedList <T extends Comparable> {
    private Node<T> head;
    public  double MemoryAccess=0;
    public  double MemoryAccess2=0;
    
    

    public Node<T> createNode(T val){
        return new Node<T>(val);
    }



    public void insertToFront(T val){
        Node<T> newNode=createNode(val);
        newNode.next=head; 
        head=newNode;
    }
    public void insertToEnd(T val){
        Node<T> newNode=createNode(val);
        if(head==null){
            head=newNode;
            return;
        }
        Node<T> iterator=head;
        while(iterator.next!=null)
            iterator=iterator.next;
            
        iterator.next=newNode;

    }
    public void display(){
        Node<T> iterator=head;
        while(iterator!=null){
            System.out.println(iterator);
            iterator=iterator.next;
        }

        

    }

    public boolean Search(T val){
        
        Node<T> iterator=head;
        while (iterator!=null){
            if(iterator.value==val){
                return true;

            }
            iterator=iterator.next;

        }
        return false;
        
    }



        public void SearchForTotalMemoryAccess(T val){

        
        
        Node<T> iterator=head;
        while (iterator!=null){
            if(iterator.value==val){ // +1 memory access for the if statement , iterator.value
                
                MemoryAccess++; 
                
                

                return;

            }
            iterator=iterator.next; // +1 memory access for , iterator.next
            
            MemoryAccess=MemoryAccess+2; // combined 1 above and if statement

        }

        
        
    }

    







        public void SearchAndPutToFront(T val){


        
        Node<T> iterator=head;
        Node<T> previous=head;
        
        
        while (iterator!=null){
            
            if(iterator.value==val){
                MemoryAccess2++; //+1 memory access for the if statement , iterator.value
                
                if(iterator==head){
                    
                    return ;
                }
                else{

                    previous.next=iterator.next; //+1 memory access for , previous.next
                    iterator.next=head; // +1 memory access for , iterator.next
                    head=iterator;
                    
                    MemoryAccess2=MemoryAccess2+2; // combined 2 above
                    //MemoryAccess2=MemoryAccess2+3;
                    

                }

                    
                    

                
                

                

            }
            else{
            previous=iterator;
            iterator=iterator.next; // +1 memory access for , iterator.next
            //MemoryAccess2++;
            MemoryAccess2=MemoryAccess2+2; // combined 1 above and if statement
            }
            
            

        }

        
    }


















    public int count(){
        Node<T> iterator = head;
        int count=0;
        while(iterator!=null){
            count=count+1;
            iterator=iterator.next;
        }
        return count;

    }

    public  T findMin(){
        Node<T> iterator = head;
        T min = iterator.value;
        while(iterator!=null){
            if(iterator.value.compareTo(min)<0){
                min = iterator.value;
            }
            iterator=iterator.next;
            
        }
        return min;

    }



    public void sortedInsert(T val){
        Node<T> newNode=createNode(val);
        if(head==null)
            head=newNode;
        else if (val.compareTo(head.value)<=0){
            newNode.next=head;
            head=newNode;
        }else{
            Node<T> iterator=head;
            while(iterator.next!=null && iterator.next.value.compareTo(val)==-1){
                iterator=iterator.next;
            }
            newNode.next=iterator.next;
            iterator.next=newNode;
            
        }
    }

    public void deleteTheFirst(){
        if(head!=null)
            head=head.next;
    }
    public void delete(T val){
        if(head==null)
            return;
        if(head.value.compareTo(val)==0)
            head=head.next;
        else{
            Node<T> previous=head; 
            Node<T> iterator=head;
            while(iterator!=null && iterator.value.compareTo(val)!=0)   {
                previous=iterator;
                iterator=iterator.next;
            }
            if(iterator!=null)
                previous.next=iterator.next;


        }
}

public void recursiveAddToEnd(T val){
    head=recursiveAddToEnd(head, val);
}

public Node<T> recursiveAddToEnd(Node<T> tempHead, T val)
    {
        if(tempHead==null)
            return createNode(val);
        else{
            tempHead.next=recursiveAddToEnd(tempHead.next, val);
        }
        return tempHead;
    }

    public void swapFirstAndLastNodes(){
        if (head==null || head.next==null)
            return;
        Node<T> iterator=head, previous=head;
        while(iterator.next!=null){
            previous=iterator;
            iterator=iterator.next;
        }
        if(head.next==iterator){
            iterator.next=head;
            head.next=null;
            head=iterator;
        }else{
            iterator.next=head.next; 
            previous.next=head;
            head.next=null;
            head=iterator;
        }



    }



}