<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<div class="container">
  <div class="card card-login mx-auto mt-5">
    <div class="card-header">Reset Password</div>
    <div class="card-body">
      <div class="text-center mb-4">
        <h4>Forgot your password?</h4>
        <p>Enter your email address and we will send you instructions on how to reset your password.</p>
      </div>
      <form>
        <div class="form-group">
          <div class="form-label-group">
            <input type="email" id="inputEmail" class="form-control" placeholder="Enter email address" required="required" autofocus="autofocus">
            <label for="inputEmail">Enter email address</label>
          </div>
        </div>
        <a class="btn btn-primary btn-block" href="login.do">Reset Password</a>
      </form>
      <div class="text-center">
        <a class="d-block small mt-3" href="register.do">Register an Account</a>
        <a class="d-block small" href="login.do">Login Page</a>
      </div>
    </div>
  </div>
</div>
