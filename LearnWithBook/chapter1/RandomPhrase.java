package LearnWithBook.chapter1;

public class RandomPhrase {
    public static void main(String[] args) {

        String[] WordListOne = {"круглосуточный", "трехзвенный", "30000-фунтовый", "взаимный", "обюдный выигрыш",
                                "фронтэнд", "на основе вебтехнологий", "проникающий", "умный", "шесть сигм",
                                "метод критического пути", "динамичный"};
        String[] WordListTwo = {"уполномоченный", "трудный", "чистый продукт", "ориентированный", "центральный",
                                "распределенный", "кластеризованный", "фирменный", "нестандартный ум", "позиционированный",
                                "сетевой", "сфокусированный", "использованный с выгодой", "выровненный",
                                "нацеленный на", "общий", "совместный", "ускореный"};
        String[] WordListThree = {"процесс", "пункт разгрузки", "выход из приложения", "тип структуры", "талант",
                                "подход", "уровень завоеванного внимания", "портал", "период времени", "обзор",
                                "образец", "пункт следования"};

        int Rand1 = (int) (Math.random() * WordListOne.length);
        int Rand2 = (int) (Math.random() * WordListTwo.length);
        int Rand3 = (int) (Math.random() * WordListThree.length);

        String Phrase = WordListOne[Rand1] + " " + WordListTwo[Rand2] + " " + WordListThree[Rand3];
        System.out.println("Все что вам нужно, - это " + Phrase);
    }
}
