USE shopr;
ALTER TABLE cart Modify id VARCHAR(50) not null;
# ALTER TABLE cart Modify user_id VARCHAR(50) null;
ALTER TABLE user MODIFY cart_id VARCHAR(50) null;
ALTER TABLE cartitem MODIFY id VARCHAR(50) NOT NULL;
ALTER TABLE cartitem MODIFY cart_id VARCHAR(50) null;
ALTER TABLE cart Add column cart_user_id VARCHAR(50) null;