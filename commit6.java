public JSONObject addNewTask(String title, String description,
                              String dueDateStr, String priorityLevel) {

    if (!isValidTitle(title)) {
        System.out.println("Lỗi: Tiêu đề không được để trống.");
        return null;
    }

    LocalDate dueDate = parseDueDate(dueDateStr);
    if (dueDate == null) {
        System.out.println("Lỗi: Ngày đến hạn không hợp lệ. Định dạng đúng: YYYY-MM-DD.");
        return null;
    }

    if (!isValidPriority(priorityLevel)) {
        System.out.println("Lỗi: Mức độ ưu tiên không hợp lệ. Chọn: Thấp, Trung bình, Cao.");
        return null;
    }

    JSONArray tasks = loadTasksFromDb();

    if (isDuplicateTask(tasks, title, dueDate)) {
        System.out.printf("Lỗi: Nhiệm vụ '%s' đã tồn tại với cùng ngày đến hạn.\n", title);
        return null;
    }

    JSONObject newTask = createTask(title, description, dueDate, priorityLevel);
    tasks.add(newTask);
    saveTasksToDb(tasks);

    System.out.printf("Thêm nhiệm vụ thành công với ID: %s\n", newTask.get("id"));
    return newTask;
}
