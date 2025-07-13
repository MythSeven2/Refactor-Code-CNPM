private boolean isValidTitle(String title) {
    return title != null && !title.trim().isEmpty();
}

private LocalDate parseDueDate(String dueDateStr) {
    try {
        return LocalDate.parse(dueDateStr, DATE_FORMATTER);
    } catch (DateTimeParseException e) {
        return null;
    }
}

private boolean isValidPriority(String priority) {
    return List.of("Thấp", "Trung bình", "Cao").contains(priority);