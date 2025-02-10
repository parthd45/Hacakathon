

// Function to show alert message
function showMessage(message) {
    alert(message);
}

// Search Bar Interaction
document.querySelector('.search-bar').addEventListener('keyup', function(event) {
    console.log('Searching for:', event.target.value);
});
