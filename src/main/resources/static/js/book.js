// 삭제 기능
const deleteButton = document.getElementById('delete-btn');

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('book-id').value;
        fetch(`/api/books/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert('삭제가 완료되었습니다.');
                location.replace('/books');
            });
    });
}

// 생성 기능
const createButton = document.getElementById('create-btn');

if (createButton) {
    createButton.addEventListener('click', event => {
        fetch('/api/books', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                userId: document.getElementById("userId").value,
                showId: document.getElementById("showId").value,
                bookMail : document.getElementById("bookMail").value,
                bookDay : document.getElementById("bookDay").value,
                bookTime : document.getElementById("bookTime").value,
                bookPay : document.getElementById("bookPay").value,
                seatPosition : document.getElementById("seatPosition").value,
                showLocation : document.getElementById("showLocation").value
            })
        })
            .then(() => {
                alert('등록 완료되었습니다.');
                location.replace('/books');
            });
    });
}