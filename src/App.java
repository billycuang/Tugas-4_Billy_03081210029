import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        ArrayList<Nasabah> nasabah = new ArrayList<Nasabah>();
        ArrayList<String> logMutasi = new ArrayList<String>();
        //app banking
        //1. tambah nasabah
        //2. setor uang
        //3. cetak mutasi
        //4. transfer uang
        //5. cetak nasabah
        //5. keluar
        Scanner input = new Scanner(System.in);
        init(nasabah);
        String yn ="y";
        do{
            //cetak menu
            menu();

            int pilihan =0;
            pilihan = input.nextInt();

            if(pilihan==1){ //tambah data nasabah
                //scanner untuk terima inputan
                //nasabah.add inputan yg diterima dalam string, 
                String NoRek;
                String Namansb;
                long Saldo=0;
                System.out.print("Nama Nasabah \t:\t");
                Namansb =input.next();
                System.out.print("Nomor Rekening \t:\t");
                NoRek = input.next();
                System.out.print("Saldo Awal \t:\t");
                Saldo = input.nextLong();

                nasabah.add(new Nasabah(NoRek, Namansb, Saldo));
            }
            else if(pilihan==2){ //setor uang
                String NoRek;
                long setoran=0;
                System.out.print("Nomor Rekening \t:\t");
                NoRek= input.next();
                System.out.print("Nominal setoran (IDR) \t:\t");
                setoran= input.nextLong();
                //cek apakah nomor rek terdaftar? jika iya tambahakn saldonya
                //jika tidak "nomor rekening tidak ditemukan"
                // if(nasabah.contains(new Nasabah(NoRek)))
                //    System.out.println("Nomor rekening ditemukan");
                // else 
                //    System.out.println("Nomor rekening tidak ditemukan");
                int i=0; //index
                for (Nasabah nasabah2 : nasabah) {
                    if(nasabah2.getNoRek().equals(NoRek)){
                         //System.out.println(nasabah2);
                        Nasabah tmpnsb = nasabah2;
                        tmpnsb.setSaldo(tmpnsb.getSaldo() + setoran);
                        nasabah.set(i, tmpnsb); 

                        System.out.println("Setoran telah berhasil");
                        logMutasi.add("Setor uang " + setoran + " ke Rekening " + tmpnsb.getNoRek() + " " + tmpnsb.getNamansb());
                    }
                    i++;
                }
            }
            else if(pilihan==3){ //cetak mutasi
                for (String string : logMutasi) {
                    System.out.println(string);
                }
            }else if(pilihan==4){ //transfer uang
                // 1 2
                String NoRek2,NoRek3;
                long transfer;
                int i=0;
                System.out.print("Masukkan nomor rekening kamu\t:\t");
                NoRek2=input.next();
                for (Nasabah nasabah2 : nasabah) {
                    if(nasabah2.getNoRek().equals(NoRek2)){
                        System.out.println("Akun Tersedia atas nama "+nasabah2.getNamansb());
                        Nasabah temp=nasabah2;
                        System.out.print("Masukkan nomor rekening tujuan\t:\t");
                        NoRek3=input.next();
                        for (Nasabah nasabah3 : nasabah) {
                            if(nasabah3.getNoRek().equals(NoRek3)){
                                System.out.println("Akun Tujuan tersedia atas nama "+nasabah3.getNamansb());
                                Nasabah temp2=nasabah3;
                                System.out.print("Masukkan nominal yang mau ditransfer\t:\t");
                                transfer=input.nextLong();
                                for (Nasabah nasabah4 : nasabah) {
                                    if(transfer>nasabah4.getSaldo()){
                                        System.out.println("Saldo tidak mencukupi\t:\t");
                                }
                                temp.setSaldo(temp.getSaldo()-transfer);
                                nasabah.set(i, temp);
                                temp2.setSaldo(temp2.getSaldo()+transfer);
                                nasabah.set(i, temp2);
                                System.out.println("Transfer telah berhasil");
                                logMutasi.add("Transfer uang " + transfer + " ke Rekening " + temp2.getNoRek() + " " + temp2.getNamansb());
                            }
                        }                                           
                        }
                
                        i++;
                    }

                //cek apakah nomor rek 1 terdaftar? 
                //jika tidak "nomor rekening tidak ditemukan"

                //cek apakah nomor rek 2 terdaftar? 
                //jika tidak "nomor rekening tidak ditemukan"

                //pindahkan uang dari rek 1 ke rek 2
                //simpan log transfer
                } }
            
            else if(pilihan==5){ //cetak nasabah 
                cetakNamaNasabah(nasabah);
            }
            else if(pilihan==6) { break;}
            else { continue;}

            System.out.print("Apakah anda ingin kembali ke menu utama (y/n) :");
            yn = input.next();
        }while(yn.equalsIgnoreCase("y"));

       

        //scanner untuk terima inputan
        //nasabah.add inputan yg diterima dalam string, 

        // cetakNamaNasabah(nasabah);

        // nsb3.setNamansb("Kimberly");
        // nasabah.set(2,nsb3);
        // cetakNamaNasabah(nasabah);

        // hapusNasabah(nasabah,1);
        // cetakNamaNasabah(nasabah);

        // hapusNasabah(nasabah,nsb1);
        // cetakNamaNasabah(nasabah);
    }

    public static ArrayList<Nasabah> init(ArrayList<Nasabah> nasabah){
        Nasabah nsb1 =  new Nasabah("0214578","Jian",500000);
        nasabah.add(nsb1);
        Nasabah nsb2 =  new Nasabah("0214571","Gilbert",500000);
        nasabah.add(nsb2);
        Nasabah nsb3 =  new Nasabah("0214572","Kimberlly",500000);
        nasabah.add(nsb3);
        nasabah.add( new Nasabah("0214573","Wilbert",500000));
        return nasabah;
    }
    public static void menu(){
                //app banking
        //1. tambah nasabah
        //2. setor uang
        //3. cetak mutasi
        //4. transfer uang
        //5. keluar
        System.out.println("Aplikasi Banking");
        System.out.println("1. Tambah Nasabah Baru");
        System.out.println("2. Setor Uang");
        System.out.println("3. Cetak Mutasi");
        System.out.println("4. Transfer Uang");
        System.out.println("5. Cetak Data Nasabah");
        System.out.println("6. Keluar");
        System.out.print("Masukkan Pilihan Anda : ");
    }

    public static void hapusNasabah(ArrayList<Nasabah> nasabah,int idx){
        nasabah.remove(idx);
    }
    public static void hapusNasabah(ArrayList<Nasabah> nasabah,Nasabah nsb){
        nasabah.remove(nsb);
    }

    public static void cetakNamaNasabah(ArrayList<Nasabah> nasabah){
        System.out.println("No.Rekening\tNama\t\tSaldo\tNo.kartu\tPIN\tTgl. Daftar");
        System.out.println("-------------------------------------------------------------------------");
        for (Nasabah nsbh : nasabah) {
            System.out.println(nsbh);
        }
        System.out.println("-------------------------------------------------------------------------");
 
    }
}