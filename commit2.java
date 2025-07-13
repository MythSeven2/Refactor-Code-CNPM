private boolean isDuplicateTask(JSONArray tasks, String title, LocalDate dueDate) {
    for (Object obj : tasks) {
        JSONObject existingTask = (JSONObject) obj;
        String existingTitle = existingTask.get("title").toString();
        String existingDueDate = existingTask.get("due_date").toString();
        if (existingTitle.equalsIgnoreCase(title) && existingDueDate.equals(dueDate.format(DATE_FORMATTER))) {
            return true;
        }
    }
    return false;
}
