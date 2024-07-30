document.addEventListener('DOMContentLoaded', () => {
    const themeButton = document.getElementById('theme-change-button');
    const currentTheme = localStorage.getItem('theme') || 'light';

    if (currentTheme === 'dark') {
        document.body.classList.add('dark');
        themeButton.querySelector('span').textContent = 'Dark';
    } else {
        document.body.classList.remove('dark');
        themeButton.querySelector('span').textContent = 'Light';
    }

    themeButton.addEventListener('click', () => {
        const isDark = document.body.classList.toggle('dark');
        localStorage.setItem('theme', isDark ? 'dark' : 'light');
        themeButton.querySelector('span').textContent = isDark ? 'Dark' : 'Light';
    });
});
