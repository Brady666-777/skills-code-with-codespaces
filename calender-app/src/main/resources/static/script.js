const todos = {
    "2024-06-01": ["Todo 1", "Todo 2"],
    "2024-06-02": ["Todo 3"],
    "2024-06-05": ["Todo 4", "Todo 5", "Todo 6"],
};

document.addEventListener('DOMContentLoaded', () => {
    const calendar = document.getElementById('calendar');
    const now = new Date();
    const year = now.getFullYear();
    const month = now.getMonth();
    const daysInMonth = new Date(year, month + 1, 0).getDate();

    for (let day = 1; day <= daysInMonth; day++) {
        const dateStr = `${year}-${String(month + 1).padStart(2, '0')}-${String(day).padStart(2, '0')}`;
        const dayDiv = document.createElement('div');
        dayDiv.className = 'day';
        dayDiv.textContent = day;

        if (todos[dateStr]) {
            const todosDiv = document.createElement('div');
            todosDiv.className = 'todos';
            todos[dateStr].forEach(todo => {
                const todoItem = document.createElement('div');
                todoItem.textContent = todo;
                todosDiv.appendChild(todoItem);
            });
            dayDiv.appendChild(todosDiv);
        }

        calendar.appendChild(dayDiv);
    }
});
