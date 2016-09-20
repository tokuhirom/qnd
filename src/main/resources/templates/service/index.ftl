<!doctype html>
<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.5/dist/css/bootstrap.min.css">
</head>
<body>
<h1>List of services.</h1>

<a href="/service/register" class="btn btn-primary">Register new service</a>

<table class="table table-bordered">
    <tr>
        <th>Service ID</th>
        <th>Service Name</th>
        <th>Created</th>
    </tr>
<#list services as service>
    <tr>
        <td><a href="/service/${service.serviceId}">${service.serviceId!"-"}</a></td>
        <td>${service.name}</td>
        <td>${service.created!"-"}</td>
    </tr>
</#list>
</table>
</body>
</html>
