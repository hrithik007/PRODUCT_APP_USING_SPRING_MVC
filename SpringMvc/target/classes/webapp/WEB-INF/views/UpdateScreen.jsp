<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Add Product</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2 class="mt-5">Update Product</h2>
    <form action ="${pageContext.request.contextPath}/handle-product" method="POST">
        <div class="mb-3">
        <label class="form-label">Name</label>
                <input type="text" class="form-control" name="name" required value="${product.name}"> </input>
        </div>
        <div class="mb-3">
        <label class="form-label">Description</label>
                <input type="text" class="form-control" name="description" required value="${ product.description}"></input>
        </div>
        <div class="mb-3">
        <label class="form-label">Price</label>
                <input type="text" class="form-control" name="price" required value="${ product.price}"></input>
        </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</div>

<!-- Bootstrap JS (Optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
