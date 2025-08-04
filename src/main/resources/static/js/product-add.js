function previewImage(input) {
    const file = input.files[0];
    const preview = document.getElementById('imagePreview');
    const previewImg = document.getElementById('previewImg');
    const uploadLabel = document.querySelector('.file-upload-label');
    
    if (file) {
        // Check file size (5MB = 5 * 1024 * 1024 bytes)
        if (file.size > 5 * 1024 * 1024) {
            alert('File size must be less than 5MB');
            input.value = '';
            return;
        }
        
        // Check file type
        if (!file.type.startsWith('image/')) {
            alert('Please select a valid image file');
            input.value = '';
            return;
        }
        
        const reader = new FileReader();
        reader.onload = function(e) {
            previewImg.src = e.target.result;
            preview.style.display = 'block';
            uploadLabel.style.display = 'none';
        };
        reader.readAsDataURL(file);
    }
}

function removeImage() {
    const input = document.getElementById('imageFile');
    const preview = document.getElementById('imagePreview');
    const uploadLabel = document.querySelector('.file-upload-label');
    
    input.value = '';
    preview.style.display = 'none';
    uploadLabel.style.display = 'flex';
}

// Form validation
document.addEventListener('DOMContentLoaded', function() {
    document.querySelector('.product-form').addEventListener('submit', function(e) {
        const fileInput = document.getElementById('imageFile');
        const file = fileInput.files[0];
        
        if (file && file.size > 5 * 1024 * 1024) {
            e.preventDefault();
            alert('Image file size must be less than 5MB');
            return false;
        }
    });
});