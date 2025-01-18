// static/js/footer.js

const EMAIL = '2069057986@qq.com';

// 显示微信二维码弹窗
function showWechatQR() {
    document.getElementById('qrModal').style.display = 'flex';
}

// 隐藏微信二维码弹窗
function hideWechatQR() {
    document.getElementById('qrModal').style.display = 'none';
}

// 复制邮箱到剪贴板
async function copyEmail() {
    try {
        await navigator.clipboard.writeText(EMAIL);
        const copyTip = document.getElementById('copyTip');
        copyTip.style.display = 'block';
        setTimeout(() => {
            copyTip.style.display = 'none';
        }, 2000);
    } catch (err) {
        console.error('复制失败:', err);
    }
}

// 无限滚动功能
let observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            loadMoreContent();
        }
    });
}, {
    threshold: 0.5,
    rootMargin: '100px'
});

// 初始化无限滚动
function initInfiniteScroll() {
    const footer = document.querySelector('.blog-footer');
    if (footer) {
        observer.observe(footer);
    }
}

// 加载更多内容
async function loadMoreContent() {
    const loadingIndicator = document.getElementById('loadingIndicator');
    loadingIndicator.style.display = 'flex';

    try {
        // 这里添加加载更多内容的逻辑
        await fetchMoreContent(); // 你需要实现这个函数
    } finally {
        loadingIndicator.style.display = 'none';
    }
}

// 页面加载完成后初始化
document.addEventListener('DOMContentLoaded', initInfiniteScroll);
