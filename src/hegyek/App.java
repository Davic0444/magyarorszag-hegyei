package hegyek;

public class App {
    public static void main(String[] args) {

        Task taskObj = new Task();
        taskObj.fileRead("hegyekMo.txt");

        // 3. feladat
        System.out.println("Hegycsúcsok száma: " + taskObj.howManyMountains() + " db");

        // 4. feladat
        System.out.println("Hegycsúcsok átlagos magassága: " + taskObj.mountainsAvarageHeight() + " m");

        // 5. feladat
        taskObj.highestMountain();

        // 6. feladat
        taskObj.isThereHigherMountainInBorzsony();

        // 7. feladat
        taskObj.higherThen3000Feet();

        // 8. feladat
        taskObj.mountainsStatistics();

        // 9. feladat
        taskObj.fileWriteOut();

    }
}
