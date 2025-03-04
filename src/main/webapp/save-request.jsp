
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>save-request</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/request-servlet" method="post">
      <input  name="nameInput" placeholder="Name"/>
      <input  name="ageInput" placeholder="Age"/>
      <button type="submit">Submit</button>
  </form>
  </body>
</html>