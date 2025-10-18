package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 빈 문자열 입력 시 바로 0 출력 후 종료
        if (Objects.equals(input, "")) {
            System.out.println("결과 : 0");
            return;
        }

        // 입력값 검증
        validateInput(input);

        // 기본 구분자 (쉼표, 콜론)
        String delimiters = "[,:]";

        // 커스텀 구분자
        if (input.startsWith("//")) {
            String customDelimiter = validateAndGetCustomDelimiter(input);
            String escapedCustomDelimiter = java.util.regex.Pattern.quote(customDelimiter);
            delimiters = "[,:" + escapedCustomDelimiter + "]";
            input = input.substring(4);
        }

        // 구분자를 기준으로 분리
        String[] tokens = input.split(delimiters);
        for (String token : tokens) {
            validateToken(token);
        }

        // 결과 계산
        int result = 0;
        System.out.println("결과 : " + result);

    }

    private static void validateInput(String input) {
        // 공백만 있는 경우
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력값입니다: 공백만 있는 문자열은 허용되지 않습니다.");
        }
    }

    private static String validateAndGetCustomDelimiter(String input) {
        // "//"와 "\n" 사이 한 개의 문자가 아닌 경우
        if (input.length() < 4 || input.charAt(3) != '\n') {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
        return String.valueOf(input.charAt(2));
    }

    private static void validateToken(String token) {
        // 공백만 있는 경우
        if (token.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력값입니다: 공백만 있는 입력은 허용되지 않습니다.");
        }

        // 숫자 형식이 아닌 경우 (소수점, 문자 등)
        if (!token.matches("\\d+")) {
            throw new IllegalArgumentException("잘못된 입력값입니다: " + token);
        }

        // 양의 정수가 아닌 경우
        int number = Integer.parseInt(token);
        if (number <= 0) {
            throw new IllegalArgumentException("잘못된 입력값입니다: 음수 또는 0은 허용되지 않습니다. (" + token + ")");
        }
    }
}