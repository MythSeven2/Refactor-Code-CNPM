private JSONObject createTask(String title, String description, LocalDate dueDate, String priority) {
    JSONObject task = new JSONObject();
    task.put("id", generateTaskId());
    task.put("title", title);
    task.put("description", description);
    task.put("due_date", dueDate.format(DATE_FORMATTER));
    task.put("priority", priority);
    task.put("status", "Chưa hoàn thành");
    String now = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    task.put("created_at", now);
    task.put("last_updated_at", now);
    return task;
}
