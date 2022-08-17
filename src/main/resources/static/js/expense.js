let saveOnclck = function (){
    alert("aaa")
}

let openPopup = function(url, name){
    var options = 'top=10, left=10, width=500, height=600, status=no, menubar=no, toolbar=no, resizable=no';
    window.open(url, name, options);
}

const postForm = function(path, params, method) {
    method = method || 'post';

    let form = document.createElement('form');
    form.setAttribute('method', method);
    form.setAttribute('action', path);

    for (let key in params) {
        if (params.hasOwnProperty(key)) {
            let hiddenField = document.createElement('input');
            hiddenField.setAttribute('type', 'hidden');
            hiddenField.setAttribute('name', key);
            hiddenField.setAttribute('value', params[key]);

            form.appendChild(hiddenField);
        }
    }

    document.body.appendChild(form);
    form.submit();
}