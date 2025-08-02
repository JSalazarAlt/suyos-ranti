function validateChangePasswordForm() {
    // Get the form field values
    const currentPassword = document.getElementById("currentPassword").value;
    const newPassword = document.getElementById("newPassword").value;
    const confirmPassword = document.getElementById("confirmPassword").value;

    // Clear any previous error messages
    const errorMessages = document.getElementById("error-messages-client");
    const errorList = document.getElementById("error-list");
    errorList.innerHTML = ""; // Clear the list
    errorMessages.style.display = "none"; // Hide error container initially

    let hasError = false;

    // Check if any field is empty
    if (!currentPassword) {
        const errorItem = document.createElement("li");
        errorItem.textContent = "Current password is required.";
        errorList.appendChild(errorItem);
        hasError = true;
    }
    if (!newPassword) {
        const errorItem = document.createElement("li");
        errorItem.textContent = "New password is required.";
        errorList.appendChild(errorItem);
        hasError = true;
    }
    if (!confirmPassword) {
        const errorItem = document.createElement("li");
        errorItem.textContent = "Confirm password is required.";
        errorList.appendChild(errorItem);
        hasError = true;
    }

    // Check if the new password and confirm password match
    /** TODO_22 (a): Use the && operator and add another check to confirm the password and its confirmation matches **/
    if (newPassword && confirmPassword && newPassword !== confirmPassword) {
        const errorItem = document.createElement("li");
        errorItem.textContent = "New password and confirm password do not match.";

        /** TODO_22 (b): Add/append the error item to the errorList using appendChild() **/
        errorList.appendChild(errorItem);

        /** TODO_22 (c): Set the boolean variable "hasError" to true **/
        hasError = true;

    }

    // Display errors if there are any
    if (hasError) {
        errorMessages.style.display = "block";
        // Stop the form from submitting
        return false;
    }

    // Allow form submission if there are no errors
    return true;
}
