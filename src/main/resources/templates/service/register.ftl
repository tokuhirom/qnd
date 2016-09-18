<#-- @ftlvariable name="services" type="java.util.List<me.geso.qnd.entity.Service>" -->
<!doctype html>
<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.5/dist/css/bootstrap.min.css">
</head>
<body>

<h1>Register new service</h1>

<form method="post" action="/service/register">
    <div class="form-group">
        <label for="serviceName">Name</label>
        <input type="text" class="form-control" id="serviceName" placeholder="Name of new service" name="name" required>
    </div>
    <div class="form-group">
        <button class="btn btn-primary">Register new service</button>
    </div>
</form>

</body>
</html>
