$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/api/customer/1"
    }).then(function(data) {
       
       $('#id').append(data.id);
       $('#firstName').append(data.firstName);
       $('#lastName').append(data.lastName);
       $('#email').append(data.email);
       $('#tel').append(data.tel);
    });
});