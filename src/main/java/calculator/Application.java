package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String[] tokens = input.split("[,:]");
        for (String token : tokens) {
            // 숫자인지 확인
            if (!token.matches("\\d+")) {
                throw new IllegalArgumentException("잘못된 입력값입니다: " + token);
            }

            // 양수인지 확인
            int number = Integer.parseInt(token);
            if (number <= 0) {
                throw new IllegalArgumentException("음수 또는 0은 허용되지 않습니다: " + token);
            }
        }

        int result = 0;
        System.out.println("결과 : " + result);

    }
}