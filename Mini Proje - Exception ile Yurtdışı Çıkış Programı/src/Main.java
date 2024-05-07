
public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("sabiha Gokçen hava limanına hoşgeldiniz..");
        String sartlar ="YURT DIŞI KURALLARI\n"
                + "herhangi bir siyasi yasak bulunmaması gerekiyor\n"
                + "15 tl harc bedelinizin tam olması gerekiyor\n"
                + "Gideceğiniz ülkeye vizeniz olması gerekiyor\n";
        while(true){
            System.out.println("***********************************");
            System.out.println(sartlar);
            System.out.println("***********************************");
            
            Yolcu yolcu =new Yolcu();
            
            System.out.println("Harc bedeli kontrol ediliyor");
            Thread.sleep(3000);
            
            try {
                yolcu.harcKontrol();
            } catch (HarcException e) {
                e.printStackTrace();
            }
            
            System.out.println("Siyasi yasak kontrol ediliyor");
            Thread.sleep(3000);
            
             try {
                yolcu.siyasiYasakKontrol();

            } catch (SiyasiYasakException e) {
                e.printStackTrace();
            }
             
            System.out.println("Vize kontrol Ediliyor");
            Thread.sleep(3000);
            try {
                yolcu.vizeKontrol();

            } catch (vizeDurumu e) {
                e.printStackTrace();
            }
            
            if(yolcu.topluKontrol()==true){
                break;
            }
            else{
                continue;
            }
        }
    }
}
