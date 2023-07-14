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
                userEmail: document.getElementById("user").value,
                showId: document.getElementById("show").value,
//                user.userId : document.getElementById("userId").value,
//                show.showId : document.getElementById("showId").value,
                showDate : document.getElementById("showDate").value,
                seat : document.getElementById("seat").value
            })
        })
            .then(() => {
                alert('등록 완료되었습니다.' + document.getElementById("user").value + ", " + document.getElementById("show").value);
                location.replace('/books');
            })
            .catch(() => {
                alert('등록 실패');
                location.replace('/books');
            });
    });
}