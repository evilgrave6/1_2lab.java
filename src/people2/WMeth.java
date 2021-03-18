package people2;
import java.util.Arrays;
import java.util.Scanner;

class People{
    String name, fam;
    double god, mes;
}
public class WMeth {

    public static People[] SetPeopleArr(int k) {
        Scanner sc = new Scanner(System.in);
        People people2[] = new People[k];
        for (int i = 0; i < people2.length; i++) {
            sc.nextLine();
            people2[i] = new People();
            System.out.print("введите фамилию " + (i + 1) + " человека: ");
            people2[i].fam = sc.nextLine();
            System.out.print("введите его имя: ");
            people2[i].name = sc.nextLine();
            System.out.print("введите его год рождения: ");
            people2[i].god = sc.nextDouble();
            System.out.print("введите месяц рождения: ");
            people2[i].mes = sc.nextDouble();
        }
        return people2;
    }

    public static void showArray1(People[] ppl) {
        for (int i = 0; i < ppl.length; i++) {
            System.out.println("" + ppl[i].fam + "\t" + ppl[i].name + "\t" + ppl[i].god + "\t" + ppl[i].mes);
        }
    }

    public static void showPeople1(People ppl) {
        System.out.println("" + ppl.fam + "\t" + ppl.name + "\t" + ppl.god + "\t" + ppl.mes);
    }

    public static int MinGod(People[] ste) {
        int mingod = 0;
        double min = ste[mingod].god;
        for (int i = 0; i < ste.length; i++)
            if (ste[i].god > mingod) {
                min = ste[i].god;
                mingod = i;
            }
        return mingod;
    }


    public static double SrednGod(People[] ppl) {
        double s = 0;
        for (int i = 0; i < ppl.length; i++) {
            s += ppl[i].god;
        }
        double sr = s / ppl.length;
        return sr;
    }

    public static People [] Bigger1(People ppl[]){
        double sred=SrednGod(ppl);
        int kol=0;
        for (int i = 0; i < ppl.length; i++) {
            if (ppl[i].god>sred)
                ++kol;
        }
        if (kol != 0){
            People [] StarChel=new People[kol];
            int n=-1;
            for (int i = 0; i < ppl.length; i++)
                if (ppl[i].god<sred) {
                    StarChel[++n]=ppl[i];
                }
            return StarChel;
        } else return null;
    }

    public static void sortFam(People[] ppl) {

        for (int i = 0; i < ppl.length - 1; i++)
            for (int j = 0; j < ppl.length - i - 1; j++)
                if (ppl[j].fam.compareTo(ppl[i + 1].fam) > 0) {
                    People rab = ppl[j];
                    ppl[j] = ppl[j + 1];
                    ppl[j + 1] = rab;
                }
    }


    public static People findFN(People ppl[], String fam){
            int n=-1;
            for (int i = 0; i < ppl.length; i++)
                if (fam.equals(ppl[i].fam))
                    n=i;
            if (n!= -1) {
                return ppl[n];
            }else return null;
        }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Сколько всего людей, хотите записать? ");
        int n=sc.nextInt();
        People people2[]= SetPeopleArr(n);

        showArray1(people2);

        int mingod=MinGod(people2);
        System.out.println("старым человеком из них является: ");
        showPeople1(people2[mingod]);

        System.out.println("Средний возраст = "+SrednGod(people2));

        System.out.println("\nлюди старше среднего возраста: ");
        People [] larger=Bigger1(people2);
        showArray1(larger);

        sortFam(people2);
        System.out.println("\nОтсортированный список: ");
        showArray1(people2);

        System.out.println("\nпоиск \n Введите фамилию человека: ");
        sc.nextLine();
        String sname=sc.nextLine();
        People sfind =findFN(people2, sname);
        if (sfind!=null) {
            showPeople1(sfind);
        } else {
            System.out.println("Такого человека нет в списке!");
        }
    }
}



