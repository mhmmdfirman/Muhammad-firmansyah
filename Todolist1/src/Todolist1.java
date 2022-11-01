import java.util.Scanner;

class TodoList1{
    
    public static String model[] = new String[10];
    
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        viewShowTodoList();
        
    }
    
    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }
    
    static void testInput() {
        var name = input("Nama");
        var channel = input("Channel");
        System.out.println("Hi " + name);
        System.out.println(channel);
    }
    
    static void showTodoList() {
        System.out.println("TODOLIST");
        for (int i = 0; i < model.length; i++) {
            String todo = model[i];
            int no = i + 1;
            
            if (todo != null) {
            System.out.println(no + ". " + todo);
                
            }
        }
    }
    
    static void testshowTodoList() {
        showTodoList();
    }
    
    static void addTodoList(String todo) {
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }
        
        // isFull so resize
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];
            
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }
        
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }
     
    static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Test todo list ke-" + i);
        }
        showTodoList();
    }
    
    static boolean removeTodoList(Integer no) {
        if ((no - 1) >= model.length) {
            return false;
        } else if (model[no - 1] == null) {
            return false;
        } else {
            
            for (int i = (no -1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else{
                model[i] = model[i + 1];   
                }
            }
            return true;
        }
    }
    
    static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        var result = removeTodoList(20);
        System.out.println(result);
        
        result = removeTodoList(7);
        System.out.println(result);
        
        result = removeTodoList(2);
        System.out.println(result);
        showTodoList();
    }
    
   static void viewShowTodoList() {
       while(true){
       showTodoList();
       
       System.out.println("Menu : ");
       System.out.println("1. Tambah");
       System.out.println("2. Hapus");
       System.out.println("x. Keluar");
       
       var input = input("pilih");
       if (input.equals("1")) {
           viewAddTodoList();
        } else if (input.equals("2")) {
            viewRemoveTodoList();
        } else if (input.equals("x")) {
            break;
        } else  {
            System.out.println("404 (Tidak ditemukan)");
        }
       }
   } 
   
   static void testViewShowTodoList() {
       addTodoList("Satu");
       addTodoList("Dua");
       addTodoList("Tiga");
       
       viewShowTodoList();
   }
   
   static void viewAddTodoList() {
       System.out.println("Menamabah TODOLIST");
       
       var todo = input("Todo (pilih x jika batal)");
       
       if(todo.equals("x")){
           //batal
       } else {
           addTodoList(todo);
       }
   }
   
   static void testViewAddTodoList() {
       addTodoList("Satu");
       addTodoList("Satu");
       addTodoList("Satu");
       
       viewAddTodoList();
       showTodoList();
   }
   
   static void viewRemoveTodoList() {
       System.out.println("Menghapus TODOLIST");
       
       var number = input("Nomor yang dihapur(x jika batal)");
       
       if (number.equals("x")) {
           //batal
       } else{
           boolean success = removeTodoList(Integer.valueOf(number));
           if(!success) {
               System.out.println("Gagal menghapus TodoList : " + number);
           }
       }
   }

    static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        
        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}