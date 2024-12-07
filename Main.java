import java.util.*;
/**
 * Основний клас для виконання операцій з матрицями.
 * У програмі реалізовано:
 * - генерацію випадкових матриць;
 * - виконання побітового XOR між двома матрицями;
 * - обчислення специфічної суми елементів у результатуючій матриці.
 */
public class Main {
    /**
     * Головний метод для демонстрації роботи з матрицями.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {

        //Мій варіант
        int my_var = 2108;
        System.out.println("C3=" + my_var % 3);
        System.out.println("C17=" + my_var % 17);
        //Задача речення
        StringBuffer inputText = new StringBuffer("Це перше речення. Це друге речення, з комою після спільного слова. Третє речення чи не речення? У цьому рядку теж є слово 'речення'. А ось тут немає!");

        //розділення тексту на речення
        String[] sentences = inputText.toString().split("[.?!]\\s*");
        //збереження кількості повторень кожного слова
        Map<String, Integer> commonWordsCount = new HashMap<>();

        for (String sentence : sentences) {
            //створюємо набір слів
            Set<String> words = new HashSet<>();


            // Видаляємо розділові знаки та розділяємо речення на слова
            String[] wordArray = sentence.toString().replaceAll("[^a-zA-Zа-яА-ЯєЄіїІїґҐ]", " ").split("\\s+");

            //додаємо слова до набору
            for (String word : wordArray) {
                if (!word.isEmpty()) {
                    words.add(word.toLowerCase());
                }
            }
            //рахуемо всі можливі слова в реченні
            for (String word : words) {
                //збільшуємо лічильник при повторенні
                if (commonWordsCount.containsKey(word)) {
                    commonWordsCount.put(word, commonWordsCount.get(word) + 1);
                } else {
                    commonWordsCount.put(word, 1);
                }
            }
        }

        //найбільша кількість повторень
        int maxCount = 0;
        for (int count : commonWordsCount.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        //Виведення результату
        System.out.println("Найбільша кількість речень з однаковими словами: " + maxCount);
    }
}