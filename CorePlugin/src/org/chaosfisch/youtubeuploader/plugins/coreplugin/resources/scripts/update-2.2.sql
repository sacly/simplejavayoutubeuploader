ALTER TABLE QUEUE ADD thumbnailimage VARCHAR(16777216);
ALTER TABLE QUEUE ADD THUMBNAILID INTEGER;
ALTER TABLE QUEUE ADD THUMBNAIL BOOLEAN;
ALTER TABLE QUEUE ADD NUMBER SMALLINT;
ALTER TABLE PRESETS ALTER COLUMN AUTOTITLEFORMAT RENAME TO TITLE;
ALTER TABLE PRESETS DROP AUTOTITLE;