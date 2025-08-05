function previewImages(input) {
    const files = input.files;
    const previewContainer = document.getElementById('imagesPreview');
    const uploadLabel = document.querySelector('.file-upload-label');
    
    // Clear previous previews
    previewContainer.innerHTML = '';
    
    if (files.length > 0) {
        uploadLabel.style.display = 'none';
        
        Array.from(files).forEach((file, index) => {
            // Check file size (5MB = 5 * 1024 * 1024 bytes)
            if (file.size > 5 * 1024 * 1024) {
                alert(`File ${file.name} is too large. Max size is 5MB`);
                return;
            }
            
            // Check file type
            if (!file.type.startsWith('image/')) {
                alert(`File ${file.name} is not a valid image`);
                return;
            }
            
            const reader = new FileReader();
            reader.onload = function(e) {
                const previewDiv = document.createElement('div');
                previewDiv.className = 'image-preview-item';
                previewDiv.innerHTML = `
                    <img src="${e.target.result}" alt="Preview ${index + 1}" class="preview-image">
                    <button type="button" class="remove-image" onclick="removeImagePreview(this, ${index})">&times;</button>
                    <span class="image-order">${index + 1}</span>
                `;
                previewContainer.appendChild(previewDiv);
            };
            reader.readAsDataURL(file);
        });
        
        previewContainer.style.display = 'flex';
    } else {
        uploadLabel.style.display = 'flex';
        previewContainer.style.display = 'none';
    }
}

function removeImagePreview(button, index) {
    const input = document.getElementById('imageFiles');
    const previewContainer = document.getElementById('imagesPreview');
    const uploadLabel = document.querySelector('.file-upload-label');
    
    // Remove the preview item
    button.parentElement.remove();
    
    // If no more previews, show upload label
    if (previewContainer.children.length === 0) {
        uploadLabel.style.display = 'flex';
        previewContainer.style.display = 'none';
        input.value = '';
    }
}

function clearAllImages() {
    const input = document.getElementById('imageFiles');
    const previewContainer = document.getElementById('imagesPreview');
    const uploadLabel = document.querySelector('.file-upload-label');
    
    input.value = '';
    previewContainer.innerHTML = '';
    previewContainer.style.display = 'none';
    uploadLabel.style.display = 'flex';
}

// Form validation
document.addEventListener('DOMContentLoaded', function() {
    document.querySelector('.product-form').addEventListener('submit', function(e) {
        const fileInput = document.getElementById('imageFiles');
        const files = fileInput.files;
        
        // Validate each file
        for (let i = 0; i < files.length; i++) {
            if (files[i].size > 5 * 1024 * 1024) {
                e.preventDefault();
                alert(`File ${files[i].name} is too large. Max size is 5MB`);
                return false;
            }
            
            if (!files[i].type.startsWith('image/')) {
                e.preventDefault();
                alert(`File ${files[i].name} is not a valid image`);
                return false;
            }
        }
    });
});