package Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidationController {

    private static Map<String, String> regexpNameRules = new HashMap<>();
    private static Map<String, String> regexpDniRules = new HashMap<>();
    private static Map<String, String> regexpDateRules = new HashMap<>();
    private static Map<String, String> regexpTelephoneRules = new HashMap<>();

    public static void init() {
        regexpNameRules.put("(.*)(\\d+)(.*)", "No están permitidos los números en el nombre y los apellidos");
        regexpNameRules.put("^(\\s+)(.*)", "El nombre y los apellidos no pueden ser ni empezar por un espacio en blanco");

        regexpDniRules.put("\\d{8}[A-Z]{1}", "El formato del DNI es el siguiente: '00000000A'");

        regexpDateRules.put("\\d{2}/\\d{2}/\\d{4}","El formato de la fecha debe ser dd/mm/yyyy");

        regexpTelephoneRules.put("[9|6|7]\\d{8}","El formato del teléfono debe ser (9|6|7)00000000");
    }

    public static List<String> validateOnlyLetters(String stringToValidate) {
        List<String> errors = regexpNameRules.entrySet().stream()
                .flatMap(regexp -> stringToValidate.matches(regexp.getKey()) ? Stream.of(regexp.getValue()) : null)
                .collect(Collectors.toList());
        return errors;
    }

    public static List<String> validateDniFormat(String dniToValidate) {
        List<String> errors = regexpDniRules.entrySet().stream()
                .flatMap(regexp -> dniToValidate.matches(regexp.getKey()) ? null : Stream.of(regexp.getValue()))
                .collect(Collectors.toList());
        return errors;
    }

    public static List<String> validateTelephoneFormat(String telephoneToValidate) {
        List<String> errors = regexpTelephoneRules.entrySet().stream()
                .flatMap(regexp -> telephoneToValidate.matches(regexp.getKey()) ? null : Stream.of(regexp.getValue()))
                .collect(Collectors.toList());
        return errors;
    }

}
