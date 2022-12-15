package task2;

public class Array <T>{
    private T [] array;

    public T getArrIndex(int i){
        return  array[i] ;
    }

    public void setArr(T [] array){
        this.array =  array;
    }

    public int getLength(){
        return  array.length ;
    }

    public static <T> void  show (T [] arr){

        T [] a = arr;
        Array <T> array = new Array <T> ();
        array.setArr(a);

        System.out.print(arr.getClass().getName() + "  ");

        for(int i = 0; i < array.getLength(); i++)
            System.out.print(array.getArrIndex(i) + " ");

        System.out.println();
    }



    public static void main(String [] args){

        Integer [] arr1 = { 1,2,3,4,5 };
        show(arr1);

        String [] arr2 = {"I", "like","Java"};
        show(arr2);
    }
}
