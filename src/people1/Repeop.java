package people1;
import java.util.Arrays;
import java.util.Scanner;

class People{
    String name, fam;
    double god, mes;
}
public class Repeop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Сколько всего людей, хотите записать? ");
        int n = sc.nextInt();
        People people1[] = new People[n];

        System.out.println("Введите информацию о них: ");
        for (int i = 0; i < people1.length; i++) {
            sc.nextLine();
            people1[i] = new People();
            System.out.print("введите фамилию " + (i + 1) + " человека: ");
            people1[i].fam = sc.nextLine();
            System.out.print("введите его имя: ");
            people1[i].name = sc.nextLine();
            System.out.print("введите его год рождения: ");
            people1[i].god = sc.nextDouble();
            System.out.print("введите месяц рождения: ");
            people1[i].mes = sc.nextDouble();
        }


       int mingod=0;
        double min=people1[mingod].god;
        for (int i = 0; i < people1.length; i++)
            if (people1[i].god>mingod) {
                min= people1[i].god;
                mingod=i;
            }
        System.out.println("\n ");
        System.out.println("старым человеком из них является: "+ people1[mingod].fam +"  " +people1[mingod].name+"\t"+people1[mingod].god);

        double s = 0;
        for (int i = 0; i < people1.length; i++)
            s+=people1[i].god;
        double sr=s/people1.length;
        System.out.println("средний год рождения = "+sr);
        System.out.println("\nлюди старше среднего возраста: ");
        for (int i = 0; i < people1.length; i++) {
            if (people1[i].god<sr)
                System.out.println(people1[i].fam + people1[i].name +"\t"+people1[i].god);
        }

        for (int i = 0; i < people1.length-1; i++)
            for (int j = 0; j < people1.length-i-1; j++)
                if(people1[j].fam.compareTo(people1[i+1].fam)>0){
                    People rab=people1[j];
                    people1[j]=people1[j+1];
                    people1[j+1]=rab;
                }

        System.out.println("\nОтсортированный список:");
        for (int i = 0; i < people1.length; i++) {
            System.out.println(""+people1[i].fam +"\t"+people1[i].name);

        }

        sc.nextLine();
        System.out.println("- ЭТО ПОИСКОВИК -");
        System.out.println("Введите фамилию человека, которого хотите найти:  ");
        String fam=sc.nextLine();
        int nom=-1;

        for (int i = 0; i < people1.length; i++)
            if (fam.equalsIgnoreCase(people1[i].fam))

                nom=i;
        if (nom!= -1) {
            System.out.println("Такой человек есть в нашем списке. Это " +people1[nom].fam+" "+people1[nom].name+ " "+people1[nom].god + " года рождения и родился "  +people1[nom].mes + " месяца");
        }else System.out.println("Ошибка! такого человека в этом списке нет. Проверьте правильность введенных данных");

    }
}
