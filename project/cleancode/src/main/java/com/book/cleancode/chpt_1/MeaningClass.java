//package com.book.cleancode.chpt_1;
//
//public class MeaningClass {
//
//    // 의미 있는 맥락을 추가하라 !
//    // 스스로 의미가 분명한 이름이 없지 않다. 클래스, 함수, 이름 공간에 넣어 맥락을 부여 한다 !
//
//    // 맥락이 불분명한 함수 !
//    // 함수가 조금 길고 세 변수를 함수 전반에서 사요을 하고 있다 함수를 작은 조각으로 쪼개고자 GuessStatisticsMessage 라는
//    // 클래스를 만든 후 세 변수를 클래스에 넣었다. 그러면 세 변수는 확실 히 GuessStatisticsMessage 에 속한다
//    // 이름에는 긴 이름보다는 짧은 이름이 좋긴 좋다. 단 의미가 분명한 경우에 한해서다. 이름에 불필요한 맥락을 추가하지 않도록 한다.
//    public void printGuessStatistics(char candidate, int count) {
//        String number;
//        String verb;
//        String pluralModifier;
//
//        if (count ==0) {
//            number = "no";
//            verb = "are";
//            pluralModifier = "s";
//        } else if (count == 1) {
//            number = "1";
//            verb = "is";
//            pluralModifier = "";
//        } else {
//            number = Integer.toString(count);
//            verb = "are";
//            pluralModifier = "s";
//        }
//
//        String getMessage = String.format(
//            "There %s %s %s %s", verb, number, candidate, pluralModifier
//        );
//
//        System.out.println(getMessage);
//    }
//
//    public static void main(String[] args) {
//        // 클래스로 표현할 시 훨씬 간결하고 편리하게 표현이 가능하다.
//        GuessStatisticsMessage guessStatisticsMessage = new GuessStatisticsMessage();
//        guessStatisticsMessage.make('s', 3);
//    }
//}
//
//class GuessStatisticsMessage {
//    private String number;
//    private String verb;
//    private String pluralModifier;
//
//    public String make(char candidate, int count) {
//        createPluralDependentMessageParts(count);
//        return String.format(
//            "There %s %s %s", verb, number, candidate, pluralModifier
//        );
//    }
//
//    private void createPluralDependentMessageParts(int count) {
//        if (count == 0) {
//            thereAreNoLetters(count);
//        } else if (count == 1) {
//            thereIsOneLetter(count);
//        } else {
//            thereAreManyLetters(count);
//        }
//    }
//
//    private void thereAreManyLetters(int count) {
//        number = Integer.toString(count);
//        verb = "are";
//        pluralModifier = "s";
//    }
//
//    private void thereIsOneLetter(int count) {
//        number = "1";
//        verb = "is";
//        pluralModifier = "";
//    }
//
//    private void thereAreNoLetters(int count) {
//        number = "no";
//        verb = "are";
//        pluralModifier = "s";
//    }
//}
//
//// Refactoring 을 해 봄 ... 이게 더 나을까 ... ?!?!
//class RefactoringGuessStatisticsMessage {
//
//    // TODO - ofMethod 사용하여 리팩토링 시도해 보기 ... ?!?!?!
//    static class GuessStatisticsData {
//        private String number;
//        private String verb;
//        private String pluralModifier;
//
//        public String getNumber() {
//            return number;
//        }
//
//        public void setNumber(String number) {
//            this.number = number;
//        }
//
//        public String getVerb() {
//            return verb;
//        }
//
//        public void setVerb(String verb) {
//            this.verb = verb;
//        }
//
//        public String getPluralModifier() {
//            return pluralModifier;
//        }
//
//        public void setPluralModifier(String pluralModifier) {
//            this.pluralModifier = pluralModifier;
//        }
//
//    }
//
//    public String make(char candidate, int count) {
//        GuessStatisticsData guessData = createPluralDependentMessageParts(count);
//
//        return String.format(
//                "There %s %s %s", verb, number, candidate, pluralModifier
//        );
//    }
//
//    private GuessStatisticsData createPluralDependentMessageParts(int count) {
//        if (count == 0) {
//            return thereAreNoLetters(count);
//        }
//        if (count == 1) {
//            return thereIsOneLetter(count);
//        }
//        return thereAreManyLetters(count);
//    }
//
//    private GuessStatisticsData thereAreManyLetters(int count) {
//        number = Integer.toString(count);
//        verb = "are";
//        pluralModifier = "s";
//        return
//    }
//
//    private GuessStatisticsData thereIsOneLetter(int count) {
//        number = "1";
//        verb = "is";
//        pluralModifier = "";
//    }
//
//    private GuessStatisticsData thereAreNoLetters(int count) {
//        number = "no";
//        verb = "are";
//        pluralModifier = "s";
//    }
//}
