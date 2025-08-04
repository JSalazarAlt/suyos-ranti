# RANTI: Suyos' E-commerce Platform

![Ranti Logo](src/main/resources/static/images/ranti-web.png)

**Your Everyday Market** - A modern, full-featured e-commerce platform built with Spring Boot and Thymeleaf.

## 🚀 Features

### Core Functionality
- **Product Management**: Add, edit, delete, and view products with images
- **User Authentication**: Secure login/registration system with role-based access
- **Shopping Cart**: Add products to cart and manage quantities
- **Category System**: Organize products by categories
- **Image Upload**: Support for product images up to 5MB
- **Responsive Design**: Mobile-first, professional UI/UX

### Technical Features
- **Spring Security**: Authentication and authorization
- **File Upload**: Image handling with validation
- **Database Integration**: MySQL with JPA/Hibernate
- **Modern UI**: Alibaba-inspired design with custom fragments
- **RESTful Architecture**: Clean controller structure

## 🛠️ Technology Stack

### Backend
- **Java 17+**
- **Spring Boot 3.x**
- **Spring Security**
- **Spring Data JPA**
- **Hibernate**
- **MySQL 8.0**

### Frontend
- **Thymeleaf**
- **HTML5/CSS3**
- **JavaScript (ES6+)**
- **Responsive Design**
- **Google Fonts (Montserrat)**

### Tools & Build
- **Maven**
- **Git**
- **IDE Support** (VS Code, IntelliJ IDEA)

## 📋 Prerequisites

- **Java 17** or higher
- **MySQL 8.0** or higher
- **Maven 3.6+**
- **Git**

## 🔧 Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/suyos-ranti.git
cd suyos-ranti
```

### 2. Database Setup
```sql
-- Create database
CREATE DATABASE ranti;

-- Create tables (run these queries)
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    terms_accepted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE persons (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    middle_name VARCHAR(255),
    last_name VARCHAR(255),
    address TEXT,
    phone VARCHAR(20),
    user_id BIGINT UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    img_url VARCHAR(500),
    category_id BIGINT,
    user_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE SET NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);
```

### 3. Configure Application
Update `src/main/resources/application.properties`:
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/ranti?useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=your_username
spring.datasource.password=your_password

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# File Upload Configuration
spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB
```

### 4. Run the Application
```bash
mvn spring-boot:run
```

The application will be available at: `http://localhost:8080`

## 📁 Project Structure

```
suyos-ranti/
├── src/main/java/com/suyos/ranti/
│   ├── controller/         # Traditional and REST Controllers
│   ├── model/              # Entity Classes
│   ├── repository/         # Data Access Layer
│   ├── service/            # Business Logic
│   └── RantiApplication.java
├── src/main/resources/
│   ├── static/
│   │   ├── css/           # Stylesheets
│   │   ├── js/            # JavaScript files
│   │   ├── images/        # Static images
│   │   └── uploads/       # Uploaded files
│   ├── templates/
│   │   ├── fragments/     # Reusable components
│   │   └── *.html         # Thymeleaf templates
│   └── application.properties
├── pom.xml
└── README.md
```

## 🎨 Design System

### Color Palette
- **Primary**: `#24152e` (Deep Purple)
- **Secondary**: `#ff6b35` (Orange)
- **Accent**: `#25162f` (Logo Text)
- **Background**: `#f8f9fa` (Light Gray)

### Typography
- **Primary Font**: Montserrat (Google Fonts)
- **Logo**: Montserrat SemiBold, Uppercase
- **Body**: Segoe UI, System Fonts

## 🔐 User Roles

### Customer (`CUSTOMER`)
- Browse and search products
- Add products to cart
- View product details
- Manage profile

### Admin (`ADMIN`)
- All customer permissions
- Add/edit/delete products
- Manage categories
- View all users

## 🚀 Usage

### For Customers
1. **Register/Login**: Create account or sign in
2. **Browse Products**: View product catalog
3. **Search & Filter**: Find products by category or search
4. **Add to Cart**: Select products and quantities
5. **Checkout**: Complete purchase (coming soon)

### For Sellers/Admins
1. **Add Products**: Upload product images and details
2. **Manage Inventory**: Update stock and pricing
3. **Categories**: Organize products
4. **Orders**: Process customer orders (coming soon)

## 🔄 API Endpoints

### Products
- `GET /products` - List all products
- `GET /showFormForAdd` - Add product form
- `POST /saveProduct` - Save product with image
- `GET /showFormForUpdate/{id}` - Edit product form
- `GET /deleteProduct/{id}` - Delete product

### Authentication
- `GET /login` - Login page
- `GET /register` - Registration page
- `POST /logout` - Logout user

## 🤝 Contributing

1. Fork the repository
2. Create feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Team

**Suyos Team** - *Initial work*

## 🐛 Known Issues

- Shopping cart persistence (in development)
- Payment integration (planned)
- Order management system (planned)
- Email notifications (planned)

## 🔮 Future Enhancements

- [ ] Shopping cart functionality
- [ ] Payment gateway integration
- [ ] Order tracking system
- [ ] Email notifications
- [ ] Product reviews and ratings
- [ ] Wishlist functionality
- [ ] Advanced search filters
- [ ] Admin dashboard
- [ ] Mobile app

## 📞 Support

For support, email support@ranti.com or create an issue in this repository.

---

**RANTI** - *Your Everyday Market* 🛒