// 삭제 기능
const deleteButton = document.getElementById('delete-btn');

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById("friend-id").value;
        fetch(`/api/friend/{id}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert('삭제가 완료되었습니다.');
                location.replace('/friends');
            });
    });
}

// 수정 기능
const modifyButton = document.getElementById('modify-btn');

if (modifyButton) {
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/api/articles/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            .then(() => {
                alert('수정이 완료되었습니다.');
                location.replace(`/friends/${id}`);
            });
    });
}

// 생성 기능
const createButton = document.getElementById('create-btn');

if (createButton) {
    createButton.addEventListener('click', event => {
        fetch('/api/friend', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({

                userEmail: document.getElementById('user').value,
                title: document.getElementById('title').value,
                content: document.getElementById('content').value

            })
        })
            .then(() => {
                alert('등록 완료되었습니다.' + document.getElementById('user').value);
                location.replace('/friends');
//                location.href = '/friends';

            });
    });
//}
// 생성 기능
//const createButton = document.getElementById('create-btn');

//if (createButton) {
//    // 등록 버튼을 클릭하면 /api/articles로 요청을 보낸다
//    createButton.addEventListener('click', event => {
//        body = JSON.stringify({
//            title: document.getElementById('title').value,
//            content: document.getElementById('content').value
//        });
//        function success() {
//            alert('등록 완료되었습니다.');
//            location.replace('/friends');
//        };
//        function fail() {
//            alert('등록 실패했습니다.');
//            location.replace('/friends');
//        };
//
//        httpRequest('POST','/api/friend', body, success, fail)
//    });
}