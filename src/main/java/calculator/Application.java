package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 기본 구분자 (쉼표, 콜론)
        String delimiters = "[,:]";

        // 커스텀 구분자
        if (input.startsWith("//")) {
            // "//"와 "\n" 사이의 한 개의 문자를 커스텀 구분자로 사용
            if (input.length() < 4 || input.charAt(3) != '\n') {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }
            String customDelimiter = String.valueOf(input.charAt(2));

            // 커스텀 구분자를 정규식 특수문자 이스케이프 처리
            String escapedCustomDelimiter = java.util.regex.Pattern.quote(customDelimiter);

            // 기본 구분자 + 커스텀 구분자 모두 허용
            delimiters = "[,:" + escapedCustomDelimiter + "]";
            input = input.substring(4);
        }

        // 구분자를 기준으로 분리
        String[] tokens = input.split(delimiters);
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

        // 결과 계산
        int result = 0;
        System.out.println("결과 : " + result);

    }
}