
import java.util.Scanner;

class HarcException extends ArithmeticException{
    
    @Override
    public void printStackTrace() {
        System.out.println("Lütfen harci tam yatırın");
    }
    
}
class SiyasiYasakException extends Exception{
    @Override
    public void printStackTrace(){
        System.out.println("Siyasi yasağınız bulunuyor");
    }
}
class vizeDurumu extends Exception{
    @Override
     public void printStackTrace(){
         System.out.println("Vizeniz gideceğiniz ülkeye yoktur!!");
     }       
}

public class Yolcu {
    private int harc;
    private boolean siyasiYasak;
    private boolean vizeDurumu;
    
    public Yolcu(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Yatırdığınız harç bedeli:");
        this.harc=input.nextInt();
        input.nextLine();
        
        System.out.print("Herhangi bir siyasi yasağınız bulunuyor mu?:");
        String cevap =input.nextLine();
        
        if(cevap.equalsIgnoreCase("evet")){
            this.siyasiYasak=true;
        }
        else{
            this.siyasiYasak=false;
        }
        
        System.out.print("Vizeniz buluyor mu?:");
        String cevap2=input.nextLine();
        
        if(cevap2.equalsIgnoreCase("evet")){
            this.vizeDurumu=true;
        }
        else{
            this.vizeDurumu=false;
        }
    }
    
    public void harcKontrol() throws HarcException{
        if(this.harc<15){
            throw new HarcException();
        }
        else{
            System.out.println("Harc işlemi tamam!!");
        }
    }
    
    public void siyasiYasakKontrol() throws SiyasiYasakException{
        if(this.siyasiYasak==true){
          throw new SiyasiYasakException();
        }
        else{
            System.out.println("Siyasi yasağınız bulunmuyor");
        }
    }
    
    public void vizeKontrol() throws vizeDurumu{
        if(this.vizeDurumu==true){
            System.out.println("vize işlemleri tamam!!");
        }
        else{
            throw new vizeDurumu();
        }
        
    }
    
    public boolean topluKontrol(){
        
        if(this.siyasiYasak==false && this.vizeDurumu==true && this.harc ==15){
            System.out.println("Yurt dışına çıkailirsiniz bir problem gözükmüyor"
                    + "İYİ YOLCULUKLAR");
            return true;
        }
        return false;
    }
}
