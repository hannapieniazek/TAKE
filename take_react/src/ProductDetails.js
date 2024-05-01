import React from 'react';
import { useParams, Link } from 'react-router-dom';

const ProductDetails = ({ products }) => {
  const { id } = useParams();

  const product = products.find(product => product.id === parseInt(id));

  if (!product) {
    return null;
  }

  const { title, category, brand, description, price, thumbnail } = product;

  return (
    <div>
      <h1>{title}</h1>
      <p>Category: {category}</p>
      <p>Brand: {brand}</p>
      <p>Description: {description}</p>
      <p>Price: {price}</p>
      <img src={thumbnail} alt={title} />
      <p><Link to="/">Back to Product List</Link></p>
    </div>
  );
};

export default ProductDetails;