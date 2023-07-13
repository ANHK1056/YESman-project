// 삭제 기능
const searchButton = document.getElementById('search-btn');

if (searchButton) {
    searchButton.addEventListener('click', event => {
        let searchWord = document.getElementById('searchWord').value;
        let selectRange = document.getElementById('selectRange').value;

//        location.replace(`/showSearch?searchWord=${searchWord}&range=${selectRange}`);

        location.href=`/showSearch?searchWord=${searchWord}&range=${selectRange}`;
    });
}

