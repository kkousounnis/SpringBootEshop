$(document).ready(function() {
    $.ajax({
        url: "http://ra1.anystream.eu:1090/kkspringbooteshop/api/customer/1"
    }).then(function(data) {
       
       $('#id').append(data.id);
       $('#firstName').append(data.firstName);
       $('#lastName').append(data.lastName);
       $('#email').append(data.email);
       $('#tel').append(data.tel);
    });
});