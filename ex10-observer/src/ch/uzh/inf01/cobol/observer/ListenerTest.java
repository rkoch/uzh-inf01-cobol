package ch.uzh.inf01.cobol.observer;

public class ListenerTest {

    public static void main(String[] pArgs) {
        Lecturer lecturer1 = new Lecturer("Prof. Gall");
        Lecturer lecturer2 = new Lecturer("Mein(e) Tutor(in)");

        Student student1 = new Student("Michael");
        ILectureListener student2 = new Student("Andrea");

        GuestListener guest1 = new GuestListener("Hans");
        ILectureListener guest2 = new GuestListener("Petra"); // This is obviously also possible (just referencing the interface which is implemented by the instance)

        lecturer1.registerStudent(student1);
        lecturer1.registerStudent(student2);
        lecturer1.registerStudent(guest1);
        lecturer1.registerStudent(guest2);

        lecturer2.registerStudent(student1);
        lecturer2.registerStudent(student2);
        lecturer2.registerStudent(guest1);
        lecturer2.registerStudent(guest2);

        lecturer1.distributeInformation("die Vorlesung heute ausfaellt!");
        lecturer2.distributeInformation("die Aufgaben gut geloest wurden!");

        lecturer1.unregisterStudent(student1);
        lecturer1.unregisterStudent(guest1);

        lecturer1.distributeInformation("die Pruefung leicht wird!");
        lecturer2.distributeInformation("die naechste Uebung ausfaellt!");
    }

}
